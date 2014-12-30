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
public final class ReqGuildKickMemberHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildKickMemberHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildKickMember消息
        ChatMessage.ReqGuildKickMemberMessage reqMessage = (ChatMessage.ReqGuildKickMemberMessage) getMessage();
        ChatMessage.ResGuildKickMemberMessage.Builder builder4Res = ChatMessage.ResGuildKickMemberMessage.newBuilder();
    }
}
