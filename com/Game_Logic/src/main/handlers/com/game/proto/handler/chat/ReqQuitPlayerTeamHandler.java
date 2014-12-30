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
public final class ReqQuitPlayerTeamHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqQuitPlayerTeamHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqQuitPlayerTeam消息
        ChatMessage.ReqQuitPlayerTeamMessage reqMessage = (ChatMessage.ReqQuitPlayerTeamMessage) getMessage();
        ChatMessage.ResQuitPlayerTeamMessage.Builder builder4Res = ChatMessage.ResQuitPlayerTeamMessage.newBuilder();
    }
}
