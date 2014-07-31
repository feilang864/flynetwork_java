/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.tcpclient;

import com.flynetwork_game.engine.buffer.INettyHandler;
import com.flynetwork_game.engine.buffer.NettyMessage;
import com.flynetwork_game.logicserver.tcpserver.TcpServer;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class LLTcpClientHandler implements INettyHandler {

    private final Logger logger = Logger.getLogger(LLTcpClientHandler.class);

    @Override
    public void connected(ChannelHandlerContext ctx) {
        logger.debug("注册逻辑服务器成功");        
        TcpServer.getInstance();
    }

    @Override
    public void closeed(ChannelHandlerContext ctx) {
        logger.debug("与登录服务器断开链接");
    }

    @Override
    public void actionMessage(ChannelHandlerContext ctx, NettyMessage message) {
        logger.debug("actionMessage");
    }

}
