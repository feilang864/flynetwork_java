/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import com.game_engine.poolmessage.MessageBean;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
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
 * @author Troy.Chen
 * @phone 13882122019
 *
 */
public class NettyTcpServer {

    private Logger logger = Logger.getLogger(NettyTcpServer.class);
    private int port = 9527;

    public NettyTcpServer(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void start() {
        //NioEventLoopGroup是一个多线程的I/O操作事件循环池(参数是线程数量)
        //bossGroup主要用于接受所有客户端对服务端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(2);
        //当有新的连接进来时将会被注册到workerGroup(不提供参数，会使用默认的线程数)
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);
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
                            .addLast("handler", new SimpleChannelInboundHandler<MessageBean>() {

                                /**
                                 * 收到消息
                                 *
                                 * @param ctx
                                 * @param msg
                                 * @throws Exception
                                 */
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, MessageBean msg) throws Exception {
                                    logger.info("收到消息");
                                }

                                /**
                                 * 发现异常
                                 *
                                 * @param ctx
                                 * @param cause
                                 */
                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                    logger.info("发送内部错误");
                                }

                                /**
                                 * 断开连接后
                                 *
                                 * @param ctx
                                 * @throws Exception
                                 */
                                @Override
                                public void channelUnregistered(ChannelHandlerContext ctx) {

                                }

                                /**
                                 * 创建链接后，链接被激活
                                 *
                                 * @param ctx
                                 * @throws Exception
                                 */
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) {
                                    logger.info("新建连接成功");
                                }
                            });
                        }
                    })
                    //option()方法用于设置监听套接字
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //childOption()方法用于设置和客户端连接的套接字
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // Bind and start to accept incoming connections
            //ChannelFuture cf = bs.bind(this.port).sync();
            bs.bind(this.port).sync();
            logger.info("开启端口 " + this.port);
            // Wait until the session socket is closed.
            // shut down your session.
//            cf.channel().closeFuture().sync();
        } catch (InterruptedException ex) {
            logger.info("开启端口 " + this.port + " xxxxxxxxxxxxxxxx" + ex);
        } finally {
            //关闭相关资源
//            workerGroup.shutdownGracefully();
//            bossGroup.shutdownGracefully();
        }
    }
}
