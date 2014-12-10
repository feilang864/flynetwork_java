/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import com.google.protobuf.Message;
import fly.com.object_engine.thread.TaskHandlerBase;

/**
 *
 * @author Administrator
 */
public class MessageHandler extends TaskHandlerBase {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MessageHandler.class);
    private static final long serialVersionUID = 1096031808566836222L;

    private com.google.protobuf.Message message;

    public MessageHandler() {
    }

    public Message getMessage() {
        return message;
    }

    public void setTCPHandler(Message message, Object parameter) {

    }

    @Override
    public void action() {

    }
}
