/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic.io;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import fly.com.object_engine.nio.MessageBean;
import fly.com.object_engine.nio.MessageHandler;
import fly.com.object_engine.nio.MessagePool;
import fly.com.object_engine.nio.ProtobufMessageConstructor;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class RecvMessagePool extends MessagePool {

    private static final long serialVersionUID = -9048435786184410684L;
    private static final HashMap<Long, Long> playerIds = new HashMap<>(0);

    @Override
    public void action(MessageBean msg) {
        try {
            ProtobufMessageConstructor protobuf = this.handlerMap.get(msg.getMsgid());
            MessageHandler handler = protobuf.getHandel().newInstance();
            Message message = protobuf.getMessage().newInstance().getParserForType().parseFrom(msg.getMsgbuffer());
            handler.getOthers().put("Message", message);
            //handler.getOthers().put("Player", message);
        } catch (InstantiationException | IllegalAccessException | InvalidProtocolBufferException ex) {
        }
    }

    @Override
    public void write(MessageBean msg) {

    }

}
