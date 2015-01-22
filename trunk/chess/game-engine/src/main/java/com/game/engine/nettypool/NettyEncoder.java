/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.nettypool;

import com.game.engine.messagepool.MessageBean;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.nio.ByteOrder;
import org.apache.log4j.Logger;

/**
 * 编码器
 */
class NettyEncoder extends MessageToByteEncoder<MessageBean> {

    private static final Logger logger = Logger.getLogger(NettyEncoder.class);
    ByteOrder endianOrder = ByteOrder.LITTLE_ENDIAN;

    public NettyEncoder() {

    }

    @Override
    protected void encode(ChannelHandlerContext chc, MessageBean msg, ByteBuf out) throws Exception {
        ByteBuf buffercontent = Unpooled.buffer();
        buffercontent.writeShort(msg.getMsgbuffer().length + 4)
                .writeLong(msg.getMsgid())
                .writeBytes(msg.getMsgbuffer());
        logger.debug("发送消息长度 " + (msg.getMsgbuffer().length + 4));
        out.writeBytes(buffercontent);
    }
}
