/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class ProtobufMessageConstructor {

    private static final Logger logger = Logger.getLogger(ProtobufMessageConstructor.class);
    //消息ID
    private long messageId;
    //消息执行器
    private Class<? extends MessageHandler> handel;
    //消息
    private Class<? extends com.google.protobuf.Message> message;

    public ProtobufMessageConstructor(long messageId, Class<? extends MessageHandler> handel, Class<? extends com.google.protobuf.Message> message) {
        this.messageId = messageId;
        this.handel = handel;
        this.message = message;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Class<? extends MessageHandler> getHandel() {
        return handel;
    }

    public void setHandel(Class<? extends MessageHandler> handel) {
        this.handel = handel;
    }

    public Class<? extends com.google.protobuf.Message> getMessage() {
        return message;
    }

    public void setMessage(Class<? extends com.google.protobuf.Message> message) {
        this.message = message;
    }

}
