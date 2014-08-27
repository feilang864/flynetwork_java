/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolmessage;

/**
 *
 * @author fly_troy
 */
public class MessageBean {

    private int msgid;
    private byte[] msgbuffer;

    public MessageBean(int msgid) {
        this.msgid = msgid;
    }

    public MessageBean(int msgid, byte[] msgbuffer) {
        this.msgid = msgid;
        this.msgbuffer = msgbuffer;
    }

    public int getMsgid() {
        return msgid;
    }

    public byte[] getMsgbuffer() {
        return msgbuffer;
    }

    public void setMsgbuffer(byte[] msgbuffer) {
        this.msgbuffer = msgbuffer;
    }

}
