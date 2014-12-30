package com.game.proto.handler.chat;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqDelRelationHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqDelRelationHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqDelRelation消息
        ChatMessage.ReqDelRelationMessage reqMessage = (ChatMessage.ReqDelRelationMessage) getMessage();
        ChatMessage.ResDelRelationMessage.Builder builder4Res = ChatMessage.ResDelRelationMessage.newBuilder();
    }
}
