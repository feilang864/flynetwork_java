/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.messagepool;

import io.netty.channel.ChannelHandlerContext;

/**
 *
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
