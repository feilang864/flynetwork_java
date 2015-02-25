package com.game.engine.nettypool;

import com.game.engine.nettypool.message.NettyMessageBean;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * 基于 netty 4.0.21 的 netty 服务
 *
 */
public class NettyTcpServer {

    private static final Logger log = Logger.getLogger(NettyTcpServer.class);
    private int port = 9527;
    NettyMessageHandler nettyMessageHandler;

    public NettyTcpServer(int port, NettyMessageHandler messageHandler) {
        this.port = port;
        this.nettyMessageHandler = messageHandler;
    }

    public void start() {
        //NioEventLoopGroup是一个多线程的I/O操作事件循环池(参数是线程数量)
        //bossGroup主要用于接受所有客户端对服务端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(4);
        //当有新的连接进来时将会被注册到workerGroup(不提供参数，会使用默认的线程数)
        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try {
            //ServerBootstrap是设置服务器的辅助类
            ServerBootstrap bs = new ServerBootstrap();
            //group方法是将上面创建的两个EventLoopGroup实例指定到ServerBootstrap实例中去
            bs.group(bossGroup, workerGroup)
                    //channel方法用来创建通道实例(NioServerSocketChannel类来实例化一个进来的连接)
                    .channel(NioServerSocketChannel.class)
                    //为新连接到服务器的handler分配一个新的channel。ChannelInitializer用来配置新生成的channel。(如需其他的处理，继续ch.pipeline().addLast(新匿名handler对象)即可)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //处理逻辑放到 NettyClientHandler 类中去
                            ch.pipeline().addLast("Decoder", new NettyDecoder())
                            .addLast("Encoder", new NettyEncoder())
                            //.addLast("ping", new IdleStateHandler(10, 10, 10, TimeUnit.SECONDS))
                            .addLast("handler", new SimpleChannelInboundHandler<NettyMessageBean>() {

                                /**
                                 * 收到消息
                                 *
                                 * @param ctx
                                 * @param msg
                                 * @throws Exception
                                 */
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, NettyMessageBean msg) throws Exception {
                                    nettyMessageHandler.readMessage(msg);
                                }

                                /**
                                 * 发现异常
                                 *
                                 * @param ctx
                                 * @param cause
                                 */
                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                    nettyMessageHandler.exceptionCaught(ctx, cause);
                                }

                                /**
                                 * 断开连接后
                                 *
                                 * @param ctx
                                 * @throws Exception
                                 */
                                @Override
                                public void channelUnregistered(ChannelHandlerContext ctx) {
                                    nettyMessageHandler.closeSession(ctx);
                                }

                                /**
                                 * 创建链接后，链接被激活
                                 *
                                 * @param ctx
                                 * @throws Exception
                                 */
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) {
                                    nettyMessageHandler.channelActive(ctx);
                                }
                            });
                        }
                    })
                    //option()方法用于设置监听套接字
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //childOption()方法用于设置和客户端连接的套接字
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // Bind and start to accept incoming connections
            bs.bind(this.port).sync();
            log.info("开启Tcp服务端口 " + this.port + " 监听");
        } catch (InterruptedException ex) {
            log.error("开启Tcp服务端口 " + this.port + " 监听 失败:" + ex);
            System.exit(0);
        } finally {
            //关闭相关资源
            //workerGroup.shutdownGracefully();
            //bossGroup.shutdownGracefully();
        }
    }
}
