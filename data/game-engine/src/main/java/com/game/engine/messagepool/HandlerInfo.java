/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.messagepool;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 *
 * @author fly_ty
 */
public class HandlerInfo {

    long messageID;
    ActionMessageHandler handel;
    Class<? extends com.google.protobuf.Message> message;
    long threadID;

    public HandlerInfo(long messageId, long threadId, Class<? extends ActionMessageHandler> handel, Class<? extends com.google.protobuf.Message> message) {
        this.messageID = messageId;
        this.threadID = threadId;
        try {
            this.handel = handel.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
        }
        this.message = message;
    }

    public long getMessageId() {
        return messageID;
    }

    public ActionMessageHandler getHandel() {
        return handel;
    }

    public com.google.protobuf.Message getMessage(byte[] msgbuffer) throws InstantiationException, IllegalAccessException, InvalidProtocolBufferException {
        return message.newInstance().getParserForType().parseFrom(msgbuffer);
    }

    public long getThreadID() {
        return threadID;
    }

}
