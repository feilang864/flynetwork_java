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
public final class ReqAddTeamRelationHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqAddTeamRelationHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqAddTeamRelation消息
        ChatMessage.ReqAddTeamRelationMessage reqMessage = (ChatMessage.ReqAddTeamRelationMessage) getMessage();
        ChatMessage.ResAddTeamRelationMessage.Builder builder4Res = ChatMessage.ResAddTeamRelationMessage.newBuilder();
    }
}
