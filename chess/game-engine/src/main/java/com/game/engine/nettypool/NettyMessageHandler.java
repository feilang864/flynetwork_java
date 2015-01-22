/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.nettypool;

import com.game.engine.messagepool.MessageBean;
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
     * @param session
     * @param msg
     */
    void readMessage(ChannelHandlerContext session, MessageBean msg);

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
