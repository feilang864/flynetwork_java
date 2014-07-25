/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.log4j.Logger;

/**
 * 编码器
 *
 * @author Administrator
 */
public class NettyEncoder extends MessageToByteEncoder<BaseMessage> {

    private final Logger logger = Logger.getLogger(NettyEncoder.class);

    public NettyEncoder() {
        logger.info("Create NettyEncoder");
    }

    @Override
    protected void encode(ChannelHandlerContext chc, BaseMessage msg, ByteBuf out) throws Exception {
        // todo out.writeBytes(new byte[2]);
        logger.info(msg.toString());
    }
}
