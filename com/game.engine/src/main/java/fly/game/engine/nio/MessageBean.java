/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.nio;

import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MessageBean {

    private ChannelHandlerContext channelHandlerContext;
    private long msgid;
    private byte[] msgbuffer;

    public MessageBean(ChannelHandlerContext channelHandlerContext, long msgid) {
        this.channelHandlerContext = channelHandlerContext;
        this.msgid = msgid;
    }

    public MessageBean(ChannelHandlerContext channelHandlerContext, long msgid, byte[] msgbuffer) {
        this.channelHandlerContext = channelHandlerContext;
        this.msgid = msgid;
        this.msgbuffer = msgbuffer;
    }

    public long getMsgid() {
        return msgid;
    }

    public byte[] getMsgbuffer() {
        return msgbuffer;
    }

    public void setMsgbuffer(byte[] msgbuffer) {
        this.msgbuffer = msgbuffer;
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }
}
