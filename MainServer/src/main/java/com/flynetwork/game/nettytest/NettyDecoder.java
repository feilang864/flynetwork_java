/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 解码器
 *
 * @author Administrator
 */
public class NettyDecoder extends ByteToMessageDecoder {

    private final Logger logger = Logger.getLogger(NettyEncoder.class);

    public NettyDecoder() {

        logger.info("Create NettyDecoder");
    }

    @Override
    protected void decode(ChannelHandlerContext chc, ByteBuf bb, List<Object> out) throws Exception {
        //todo out.add(byte[]);

    }

}
