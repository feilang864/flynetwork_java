/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.nettypool;

import com.game.engine.nettypool.message.NettyMessageBean;
import com.game.engine.struct.thread.TimerEventRunnable;
import com.game.engine.threadpool.TimerThread;
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
 */
public class NettyTcpClient {

    private static final Logger logger = Logger.getLogger(NettyTcpClient.class);

    private String Host = "127.0.0.1";
    private int Port = 9527;
    private Bootstrap bootstrap;
    private Channel channel;
    private boolean reConnect;
    NettyMessageHandler nettyMessageHandler;

    public NettyTcpClient(String host, int port, boolean isReConnect, NettyMessageHandler messageHandler) {
        this.Host = host;
        this.Port = port;
        this.nettyMessageHandler = messageHandler;
        reConnect = isReConnect;
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
                                if (reConnect) {
                                    TimerThread.getInstance().addTimerTask(new TimerEventRunnable(false, 1, 500, "重新连接登录服务器") {
                                        private static final long serialVersionUID = 8936220264259089420L;

                                        @Override
                                        public void run() {
                                            Connect();
                                        }
                                    });
                                }
                            }

                            @Override
                            public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                //logger.error("连接闲置");
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
                                //logger.info("向登录服务器注册成功~！");
//                                MessageBean bean = new MessageBean(ctx, 100201);
//                                bean.setMsgbuffer(new byte[5]);
//                                sendMsg(bean);
                            }
                        });
                    }
                }
                );
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    }

    @Override
    public String toString() {
        return " Host=" + Host + ", Port=" + Port;
    }

    public void Connect() {
        if (channel != null) {
            channel.close();
            channel = null;
        }
        if (channel == null) {
            try {
                logger.info("向 " + this.toString() + " 服务器注册");
                channel = bootstrap.connect(this.Host, this.Port).channel();
            } catch (Exception e) {
            }
        }
    }

    public void sendMsg(NettyMessageBean msg) {
        if (channel != null && channel.isActive()) {
            channel.writeAndFlush(msg);
        } else {
            logger.warn("消息发送失败,连接尚未建立!");
        }
    }

}
