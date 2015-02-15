package com.game.engine.nettypool;

import com.game.engine.nettypool.message.NettyMessageBean;
import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @author fly_ty
 */
public interface NettyMessageHandler {

    /**
     * 创建链接后，链接被激活
     *
     * @param session
     */
    void channelActive(ChannelHandlerContext session);

    /**
     * 收到消息
     *
     * @param msg
     */
    void readMessage(NettyMessageBean msg);

    /**
     * 断开连接
     *
     * @param session
     */
    void closeSession(ChannelHandlerContext session);

    /**
     * 发现异常
     *
     * @param session
     * @param cause
     */
    void exceptionCaught(ChannelHandlerContext session, Throwable cause);
}
