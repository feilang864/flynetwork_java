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
public final class ReqGuildInviteHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildInviteHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildInvite消息
        ChatMessage.ReqGuildInviteMessage reqMessage = (ChatMessage.ReqGuildInviteMessage) getMessage();
        ChatMessage.ResGuildInviteMessage.Builder builder4Res = ChatMessage.ResGuildInviteMessage.newBuilder();
    }
}
