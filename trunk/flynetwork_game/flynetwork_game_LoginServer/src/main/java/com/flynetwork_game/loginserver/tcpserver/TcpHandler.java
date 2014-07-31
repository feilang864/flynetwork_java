/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.tcpserver;

import com.flynetwork_game.engine.buffer.INettyHandler;
import com.flynetwork_game.engine.buffer.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class TcpHandler implements INettyHandler {

    private final Logger logger = Logger.getLogger(TcpHandler.class);

    @Override
    public void connected(ChannelHandlerContext ctx) {
        logger.debug("connected");
    }

    @Override
    public void closeed(ChannelHandlerContext ctx) {
        logger.debug("closeed");
    }

    @Override
    public void actionMessage(ChannelHandlerContext ctx, NettyMessage message) {
        logger.debug("actionMessage");
    }

    @Override
    public void inactive(ChannelHandlerContext ctx) {
        logger.debug("inactive");
    }
}
