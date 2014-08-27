/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import com.game_engine.poolmessage.MessageBean;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_troy
 */
public class NettyTcpClient{

    private final Logger logger = Logger.getLogger(NettyClientIOHandler.class);
    private String Host = "127.0.0.1";
    private int Port = 9527;
    private Bootstrap bootstrap;
    private Channel channel;
    private boolean reConnect;

    public NettyTcpClient() {
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
                        .addLast("handler", new NettyClientIOHandler());
                    }
                });
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    }

    public void run() {
        Connect();
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
