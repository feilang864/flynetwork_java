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
public final class ReqRelationListHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqRelationListHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqRelationList消息
        ChatMessage.ReqRelationListMessage reqMessage = (ChatMessage.ReqRelationListMessage) getMessage();
        ChatMessage.ResRelationListMessage.Builder builder4Res = ChatMessage.ResRelationListMessage.newBuilder();
    }
}
