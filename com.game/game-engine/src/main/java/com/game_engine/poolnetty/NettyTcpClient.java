/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import com.game_engine.poolmessage.MessageBean;
import com.game_engine.struct.GameRunnable;
import com.game_engine.utils.ThreadUtil;
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
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_troy
 */
public class NettyTcpClient {

    private static final Logger logger = Logger.getLogger(NettyTcpClient.class);

    private String Host = "127.0.0.1";
    private int Port = 9527;
    private Bootstrap bootstrap;
    private Channel channel;
    private boolean reConnect;

    public NettyTcpClient(int port) {
        this.Port = port;
        EventLoopGroup group = new NioEventLoopGroup(2);
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
                                ThreadUtil.addBackTask(new timerConnet());
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
                                MessageBean bean = new MessageBean(1000021);
                                bean.setMsgbuffer(new byte[5]);
                                sendMsg(bean);
                            }
                        });
                    }
                });
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    }

    public void Connect() {

        if (channel != null) {
            channel.close();
            channel = null;
        }

        if (channel == null) {
            try {
                channel = bootstrap.connect(this.Host, this.Port).channel();
            } catch (Exception e) {

            }
        }
    }

    class timerConnet extends GameRunnable {

        public timerConnet() {
            super("重新连接登录服务器");
        }

        @Override
        public void run() {
            try {
                logger.info("与登录服务器连接断开 500ms 重新连接~！");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            Connect();
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
