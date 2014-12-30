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
public final class ReqQuitTeamRelationHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqQuitTeamRelationHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqQuitTeamRelation消息
        ChatMessage.ReqQuitTeamRelationMessage reqMessage = (ChatMessage.ReqQuitTeamRelationMessage) getMessage();
        ChatMessage.ResQuitTeamRelationMessage.Builder builder4Res = ChatMessage.ResQuitTeamRelationMessage.newBuilder();
    }
}
