/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

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

        //若要将数据发回客户端只需要这样修改
        //根据msg做相应的逻辑处理
        //ctx.write(msg);
        //ctx.flush();		
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.info("exceptionCaught" + cause);
        //close the connection when an exception is raise

        ctx.close();
    }
}
