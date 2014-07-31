/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.buffer;

import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @author Administrator
 */
public interface INettyHandler {

    void connected(ChannelHandlerContext ctx);

    void closeed(ChannelHandlerContext ctx);

    void actionMessage(ChannelHandlerContext ctx, NettyMessage message);

}
