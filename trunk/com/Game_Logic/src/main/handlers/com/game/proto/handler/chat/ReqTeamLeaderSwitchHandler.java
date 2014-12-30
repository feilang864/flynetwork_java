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
public final class ReqTeamLeaderSwitchHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqTeamLeaderSwitchHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqTeamLeaderSwitch消息
        ChatMessage.ReqTeamLeaderSwitchMessage reqMessage = (ChatMessage.ReqTeamLeaderSwitchMessage) getMessage();
        ChatMessage.ResTeamLeaderSwitchMessage.Builder builder4Res = ChatMessage.ResTeamLeaderSwitchMessage.newBuilder();
    }
}
