/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.BufferedInputStream;
import java.nio.ByteOrder;
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
        //设置 字节数组是大端序
        //in.order(ByteOrder.BIG_ENDIAN);
        //设置 字节数组是小端序 c++, c#, U3D,都是小端序
        //out.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuf buf = Unpooled.buffer();
        //buf.order(ByteOrder.LITTLE_ENDIAN);
        ByteBufOutputStream outStream = new ByteBufOutputStream(buf);
        msg.writeMessage(outStream);
        out.writeBytes(buf);

    }
}
