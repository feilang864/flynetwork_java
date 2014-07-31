/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.netty;

import com.flynetwork_game.engine.buffer.INettyHandler;
import com.flynetwork_game.engine.buffer.NettyMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

public class NettyClient extends Thread {

    private final Logger logger = Logger.getLogger(NettyClient.class);
    private String Host = "127.0.0.1";
    private int Port = 9527;
    private Bootstrap bootstrap;
    private Channel channel;

    public NettyClient(final INettyHandler nettyHandler) {
        EventLoopGroup group = new NioEventLoopGroup(1);
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3 * 1000)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("Decoder", new NettyDecoder())
                        .addLast("Encoder", new NettyEncoder())
                        .addLast("handler", new NettyHandler(nettyHandler));
                    }
                });
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    }

    public void run() {
        if (channel == null) {
            try {
                channel = bootstrap.connect(this.Host, this.Port).channel();
            } catch (Exception e) {

            }
        }
    }

    public void reConnect() {

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

    public void sendMsg(NettyMessage msg) throws Exception {
        if (channel != null) {
            channel.writeAndFlush(msg).sync();
        } else {
            logger.warn("消息发送失败,连接尚未建立!");
        }
    }
}
