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
public final class ReqInTeamAffirmHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqInTeamAffirmHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqInTeamAffirm消息
        ChatMessage.ReqInTeamAffirmMessage reqMessage = (ChatMessage.ReqInTeamAffirmMessage) getMessage();
        ChatMessage.ResInTeamAffirmMessage.Builder builder4Res = ChatMessage.ResInTeamAffirmMessage.newBuilder();
    }
}