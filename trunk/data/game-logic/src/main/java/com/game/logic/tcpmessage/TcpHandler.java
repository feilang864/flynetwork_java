/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.logic.tcpmessage;

import com.game.engine.messagepool.MessageBean;
import com.game.engine.nettypool.NettyMessageHandler;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_ty
 */
public class TcpHandler implements NettyMessageHandler {

    private static final Logger logger = Logger.getLogger(TcpHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext session) {

        logger.info("新连接");
    }

    @Override
    public void readMessage(ChannelHandlerContext session, MessageBean msg) {
        MessageManager.getInstance().addMsg(msg);
    }

    @Override
    public void closeSession(ChannelHandlerContext session) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext session, Throwable cause) {
        cause.printStackTrace();
    }

}
