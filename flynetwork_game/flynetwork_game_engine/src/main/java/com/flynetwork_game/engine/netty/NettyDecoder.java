/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.netty;

import com.flynetwork_game.engine.buffer.IActionMessage;
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
        logger.debug("初始化解码器");
    }

    private final Logger logger = Logger.getLogger(NettyEncoder.class);
    private byte[] bytes;
    ByteOrder endianOrder = ByteOrder.LITTLE_ENDIAN;

    byte[] bytesAction(byte[] bs) {
        byte[] temps;
        if (bytes == null) {
            temps = new byte[bs.length];
            ///拷贝新的
            System.arraycopy(bs, 0, temps, 0, bs.length);
        } else {
            temps = new byte[bytes.length + bs.length];
            ///拷贝之前的
            System.arraycopy(bytes, 0, temps, 0, bytes.length);
            ///拷贝新的
            System.arraycopy(bs, bytes.length, temps, bytes.length, bs.length);
        }
        bytes = null;
        return temps;
    }

    /**
     * 留存无法读取的byte等待下一次接受的数据包
     *
     * @param bs 数据包
     * @param startI 起始位置
     * @param lenI 结束位置
     */
    void bytesAction(byte[] bs, int startI, int lenI) {
        bytes = new byte[lenI];
        ///拷贝新的
        System.arraycopy(bs, startI, bytes, 0, lenI);
    }

    @Override
    protected void decode(ChannelHandlerContext chc, ByteBuf inputBuf, List<Object> outputMessage) throws Exception {
        if (inputBuf.readableBytes() > 0) {
            //重新组装字节数组
            byte[] temp = bytesAction(inputBuf.array());
            ByteBuf buffercontent = Unpooled.buffer();
            buffercontent.writeBytes(temp);

            //读取 消息长度（short）和消息ID（int） 需要 6 个字节
            if (buffercontent.readableBytes() <= 6) {
                bytesAction(buffercontent.array(), buffercontent.readerIndex(), buffercontent.readableBytes());
            } else {
                logger.debug("decode " + buffercontent.readableBytes());
                ByteBuf buf = buffercontent.readBytes(buffercontent.readableBytes());
                //设置 字节数组是大端序
                //buf.order(ByteOrder.BIG_ENDIAN);
                //设置 字节数组是小端序 c++, c#, U3D,都是小端序            
                buf.order(endianOrder);
                int len = buf.readShort();
                if (buffercontent.readableBytes() >= len) {
                    ByteBufInputStream bufInputStream = new ByteBufInputStream(buf);
                    int messageid = bufInputStream.readInt();
                    logger.debug("收到消息 messageid " + messageid);

                    //todo 收包解包处理，
                } else {
                    buffercontent.setIndex(len, len);
                    bytesAction(buffercontent.array(), buffercontent.readerIndex(), buffercontent.readableBytes());
                }
            }
        } else {
            //todo 空包处理 考虑连续三次空包，断开链接

        }
    }
}
