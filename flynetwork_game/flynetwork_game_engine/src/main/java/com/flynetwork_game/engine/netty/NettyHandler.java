/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.netty;

import com.flynetwork_game.engine.buffer.NettyMessage;
import com.flynetwork_game.engine.buffer.INettyHandler;
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
        iNettyHandler.actionMessage(ctx, msg);
    } 

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        iNettyHandler.closeed(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        iNettyHandler.connected(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
