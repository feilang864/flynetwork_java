/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.netty;

import com.flynetwork_game.engine.buffer.IActionMessage;
import com.flynetwork_game.engine.buffer.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
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
class NettyDecoder extends ByteToMessageDecoder {

    public NettyDecoder() {

    }

    private final Logger logger = Logger.getLogger(NettyEncoder.class);
    private ByteBuf bytes;
    ByteOrder endianOrder = ByteOrder.LITTLE_ENDIAN;

    ByteBuf bytesAction(ByteBuf inputBuf) {
        ByteBuf bufferLen = Unpooled.buffer();
        if (bytes != null) {
            bufferLen.writeBytes(bytes);
            bytes = null;
        }
        bufferLen.writeBytes(inputBuf);
        return bufferLen;
    }

    /**
     * 留存无法读取的byte等待下一次接受的数据包
     *
     * @param bs 数据包
     * @param startI 起始位置
     * @param lenI 结束位置
     */
    void bytesAction(ByteBuf intputBuf, int startI, int lenI) {
        bytes = Unpooled.buffer();
        bytes.writeBytes(intputBuf, startI, lenI);
    }

    private byte ZreoByteCount = 0;

    @Override
    protected void decode(ChannelHandlerContext chc, ByteBuf inputBuf, List<Object> outputMessage) throws Exception {
        logger.debug("decode " + inputBuf.readableBytes());
        if (inputBuf.readableBytes() > 0) {
            ZreoByteCount = 0;
            //重新组装字节数组            
            ByteBuf buffercontent = bytesAction(inputBuf);
            for (;;) {
                //读取 消息长度（short）和消息ID（int） 需要 6 个字节
                if (buffercontent.readableBytes() >= 6) {
                    ///读取消息长度
                    int len = buffercontent.readShort();
                    if (buffercontent.readableBytes() >= len) {
                        int messageid = buffercontent.readInt();///读取消息ID
                        logger.info("收到消息 messageid " + messageid);
                        ByteBuf buf = buffercontent.readBytes(len);//读取可以字节数
                        buf.order(endianOrder);//设置 字节数组是小端序 c++, c#, U3D,都是小端序     ByteOrder.BIG_ENDIAN      ByteOrder.LITTLE_ENDIAN  
                        ByteBufInputStream bufInputStream = new ByteBufInputStream(buf);
                        outputMessage.add(new NettyMessage(messageid, bufInputStream));
                        //第二次重组
                        bytesAction(buffercontent, buffercontent.readerIndex(), buffercontent.readableBytes());
                        buffercontent = Unpooled.buffer();
                        buffercontent.writeBytes(bytes);
                        continue;
                        //todo 收包解包处理，
                    }
                    ///重新设置读取进度
                    buffercontent.setIndex(buffercontent.readableBytes() - 2, inputBuf.readableBytes());
                }
                ///缓存预留的字节
                bytesAction(buffercontent, buffercontent.readerIndex(), buffercontent.readableBytes());
                break;
            }
        } else {
            //todo 空包处理 考虑连续三次空包，断开链接
            logger.error("decode 空包处理 连续三次空包");
            ZreoByteCount++;
            chc.close();
        }
    }
}
