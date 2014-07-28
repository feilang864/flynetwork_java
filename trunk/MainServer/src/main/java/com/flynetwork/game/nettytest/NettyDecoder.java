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
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 解码器
 *
 * @author Administrator
 */
public class NettyDecoder extends ByteToMessageDecoder {

    private final Logger logger = Logger.getLogger(NettyEncoder.class);
    private List<Byte> bytes = new ArrayList<Byte>();

    public NettyDecoder() {

        logger.info("Create NettyDecoder");
    }

    @Override
    protected void decode(ChannelHandlerContext chc, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() > 0) {
            //读取short 需要两个字节
            if (in.readableBytes() < 6) {
                in.array();
            }
            logger.info("decode " + in.readableBytes());
            ByteBuf buf = in.readBytes(in.readableBytes());
            //设置 字节数组是大端序
            //buf.order(ByteOrder.BIG_ENDIAN);
            //设置 字节数组是小端序 c++, c#, U3D,都是小端序            
            //buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.readShort();
            ByteBufInputStream bufInputStream = new ByteBufInputStream(buf);
            int lenI = bufInputStream.readInt();
            logger.info("decode " + lenI);
            if (TipsMessage.messageID == lenI) {
                TipsMessage tipsMessage = new TipsMessage();
                tipsMessage.readMessage(bufInputStream);
                out.add(tipsMessage);
            }
        }
    }
}
