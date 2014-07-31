/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<Object> {

    public NettyClientHandler() {
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    private static final Logger logger = Logger.getLogger(NettyClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        logger.debug("client接收到服务器返回的消息:" + msg);
    }
}
