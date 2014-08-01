/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.netty;

import com.flynetwork_game.engine.buffer.BaseNettyMessage;
import com.flynetwork_game.engine.buffer.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.nio.ByteOrder;
import org.apache.log4j.Logger;

/**
 * 编码器
 *
 * @author Administrator
 */
class NettyEncoder extends MessageToByteEncoder<BaseNettyMessage> {

    private final Logger logger = Logger.getLogger(NettyEncoder.class);
    ByteOrder endianOrder = ByteOrder.LITTLE_ENDIAN;

    public NettyEncoder() {

    }

    @Override
    protected void encode(ChannelHandlerContext chc, BaseNettyMessage msg, ByteBuf out) throws Exception {
        ByteBuf buffercontent = Unpooled.buffer();
        ByteBuf bufferLen = Unpooled.buffer();
        buffercontent.order(endianOrder);//设置 字节数组是小端序 c++, c#, U3D,都是小端序  ByteOrder.BIG_ENDIAN    ByteOrder.LITTLE_ENDIAN   
        bufferLen.order(endianOrder);
        ByteBufOutputStream outStream = new ByteBufOutputStream(buffercontent);
        msg.writeMessage(outStream);
        ///消息ID、int 4 个字节
        if (buffercontent.readableBytes() >= 4) {            
            bufferLen.writeShort(buffercontent.readableBytes());
            bufferLen.writeBytes(buffercontent.readBytes(buffercontent.readableBytes()));
            logger.debug("发送消息长度 " + bufferLen.readableBytes());
            out.writeBytes(bufferLen);
        }
    }
}
