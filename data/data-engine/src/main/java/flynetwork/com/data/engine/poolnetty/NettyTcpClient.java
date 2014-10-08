/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.poolnetty;

import flynetwork.com.data.engine.manager.ThreadManager;
import flynetwork.com.data.engine.poolmessage.MessageBean;
import flynetwork.com.data.engine.poolmessage.MessagePool;
import flynetwork.com.data.engine.struct.thread.GameRunnable;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class NettyTcpClient {

    private static final Logger logger = Logger.getLogger(NettyTcpClient.class);

    private String Host = "127.0.0.1";
    private int Port = 9527;
    private Bootstrap bootstrap;
    private Channel channel;
    private boolean reConnect;

    @Override
    public String toString() {
        return " Host=" + Host + ", Port=" + Port;
    }

    public NettyTcpClient(int port) {
        this.Port = port;
        EventLoopGroup group = new NioEventLoopGroup(4);
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3 * 1000)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("Decoder", new NettyDecoder())
                        .addLast("Encoder", new NettyEncoder())
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
                                MessagePool.getInstance().registerMessage(msg);
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
                                ThreadManager.getInstance().addBackTask(new GameRunnable("重新连接登录服务器") {
                                    private static final long serialVersionUID = 3322702144147294040L;

                                    @Override
                                    public void run() {
                                        try {
                                            logger.info("与登录服务器连接断开 500ms 重新连接~！");
                                            Thread.sleep(500);
                                        } catch (InterruptedException ex) {
                                        }
                                        Connect();
                                    }
                                });
                            }

                            @Override
                            public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                logger.error("连接闲置");
                            }

                            /**
                             * 创建链接后，链接被激活
                             *
                             * @param ctx
                             * @throws Exception
                             */
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) {
                                logger.info("向登录服务器注册成功~！");
                                MessageBean bean = new MessageBean(ctx, 100201);
                                bean.setMsgbuffer(new byte[5]);
                                sendMsg(bean);
                            }
                        });
                    }
                }
                );
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    }

    public void Connect() {
        if (channel != null) {
            channel.close();
            channel = null;
        }
        if (channel == null) {
            try {
                logger.info("向服务器注册" + this.toString());
                channel = bootstrap.connect(this.Host, this.Port).channel();
            } catch (Exception e) {
            }
        }
    }

    public boolean isReConnect() {
        return reConnect;
    }

    public void setReConnect(boolean reConnect) {
        this.reConnect = reConnect;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public void sendMsg(MessageBean msg) {
        if (channel != null && channel.isActive()) {
            channel.writeAndFlush(msg);
        } else {
            logger.warn("消息发送失败,连接尚未建立!");
        }
    }

}
