/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import com.game_engine.poolmessage.MessageBean;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class NettyServerIOHandler extends SimpleChannelInboundHandler<MessageBean> {

    private final Logger logger = Logger.getLogger(NettyServerIOHandler.class);

    public NettyServerIOHandler() {

    }

    /**
     * 收到消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageBean msg) throws Exception {
        logger.info("channelRead0");
    }

    /**
     * 发现异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("exceptionCaught");
    }

    /**
     * 断开连接后
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelUnregistered");
    }

    /**
     * 创建链接后，链接被激活
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive");
    }
}
