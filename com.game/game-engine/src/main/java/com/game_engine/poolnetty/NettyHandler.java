/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class NettyHandler extends SimpleChannelInboundHandler<NettyMessage> {
    
    private final Logger logger = Logger.getLogger(NettyHandler.class);
    
    INettyHandler iNettyHandler;
    
    public NettyHandler(INettyHandler iNettyHandler) {
        this.iNettyHandler = iNettyHandler;
    }
    
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyMessage msg) throws Exception {
        logger.debug("channelRead0");
        this.iNettyHandler.actionMessage(ctx, msg);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        iNettyHandler.closeed(ctx);
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        iNettyHandler.connected(ctx);
    }
}
