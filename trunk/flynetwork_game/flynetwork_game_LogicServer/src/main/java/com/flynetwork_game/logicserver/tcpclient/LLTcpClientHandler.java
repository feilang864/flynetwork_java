/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.tcpclient;

import com.flynetwork_game.engine.buffer.INettyHandler;
import com.flynetwork_game.engine.buffer.NettyMessage;
import com.flynetwork_game.logicserver.tcpmessage.TipsMessage;
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
        //TcpServer.getInstance();
        logger.debug("注册逻辑服务器成功");
        TipsMessage tipsMessage = new TipsMessage("提示提示而已");
        ctx.writeAndFlush(tipsMessage);
    }
    ReConnectScript rcs;

    @Override
    public void closeed(ChannelHandlerContext ctx) {
        rcs = new ReConnectScript();
        logger.debug("与登录服务器链接失败");
    }

    @Override
    public void actionMessage(ChannelHandlerContext ctx, NettyMessage message) {
        logger.debug("actionMessage");
    }

}