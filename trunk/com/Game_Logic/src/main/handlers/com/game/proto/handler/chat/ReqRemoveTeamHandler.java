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
public final class ReqRemoveTeamHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqRemoveTeamHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqRemoveTeam消息
        ChatMessage.ReqRemoveTeamMessage reqMessage = (ChatMessage.ReqRemoveTeamMessage) getMessage();
        ChatMessage.ResRemoveTeamMessage.Builder builder4Res = ChatMessage.ResRemoveTeamMessage.newBuilder();
    }
}
