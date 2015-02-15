package com.game.engine.nettypool;

import com.game.engine.nettypool.message.NettyMessageBean;
import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @author fly_ty
 */
public abstract class NettyMessageHandler {

    /**
     * 创建链接后，链接被激活
     *
     * @param session
     */
    public abstract void channelActive(ChannelHandlerContext session);

    /**
     * 收到消息
     *
     * @param msg
     */
    public abstract void readMessage(NettyMessageBean msg);

    /**
     * 断开连接
     *
     * @param session
     */
    public abstract void closeSession(ChannelHandlerContext session);

    /**
     * 发现异常
     *
     * @param session
     * @param cause
     */
    public abstract void exceptionCaught(ChannelHandlerContext session, Throwable cause);

    public void send(ChannelHandlerContext session, com.google.protobuf.Message message) {

    }
}
