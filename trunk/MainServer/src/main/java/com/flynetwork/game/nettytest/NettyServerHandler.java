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

    public NettyServerHandler() {
        logger.info("Create NettyServerHandler");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx); //To change body of generated methods, choose Tools | Templates.
        logger.info("channelUnregistered");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx); //To change body of generated methods, choose Tools | Templates.
        logger.info("channelRegistered");

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx); //To change body of generated methods, choose Tools | Templates.
        logger.info("handlerRemoved");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx); //To change body of generated methods, choose Tools | Templates.
        logger.info("handlerAdded");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        ByteBuf in = (ByteBuf) msg;

        byte[] b = new byte[50];
        int i = 0;
        try {
            while (in.isReadable()) {
                b[i++] = in.readByte();
                System.out.flush();
            }
        } finally {
            in.release();
        }

        String s = new String(b);
        System.out.println(s);

        //若要将数据发回客户端只需要这样修改
        //根据msg做相应的逻辑处理
        //ctx.write(msg);
        //ctx.flush();		
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.info("exceptionCaught");
        //close the connection when an exception is raise

        ctx.close();
    }
}
