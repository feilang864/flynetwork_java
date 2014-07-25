/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.nio.ByteOrder;
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
    protected void decode(ChannelHandlerContext chc, ByteBuf in, List<Object> out) throws Exception {
        //todo out.add(byte[]);
        //设置 字节数组是大端序
        //in.order(ByteOrder.BIG_ENDIAN);
        //设置 字节数组是小端序 c++, c#, U3D,都是小端序
        logger.info("decode");
        //in.order(ByteOrder.LITTLE_ENDIAN);
        
        ByteBufInputStream bufInputStream = new ByteBufInputStream(in);
        int lenI = bufInputStream.readInt();
        if (TipsMessage.messageID == lenI) {
            TipsMessage tipsMessage = new TipsMessage();
            tipsMessage.readMessage(bufInputStream);
            out.add(tipsMessage);
        }
    }

}
