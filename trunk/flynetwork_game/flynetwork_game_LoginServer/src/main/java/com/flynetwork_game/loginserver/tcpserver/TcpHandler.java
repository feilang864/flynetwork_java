/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.tcpserver;

import com.flynetwork_game.engine.buffer.BaseMessage;
import com.flynetwork_game.engine.netty.NettyClient;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class TcpHandler extends ChannelInboundHandlerAdapter {

    private final Logger logger = Logger.getLogger(NettyClient.class);

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx); //To change body of generated methods, choose Tools | Templates.
        logger.info("移除了客户端连接");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx); //To change body of generated methods, choose Tools | Templates.
        logger.info("创建了新的客户端连接");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info(((BaseMessage) msg).toString());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.info("exceptionCaught" + cause);
        //close the connection when an exception is raise

        ctx.close();
    }
}
