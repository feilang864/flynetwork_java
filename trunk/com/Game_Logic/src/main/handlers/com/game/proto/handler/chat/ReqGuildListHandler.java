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
public final class ReqGuildListHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildListHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildList消息
        ChatMessage.ReqGuildListMessage reqMessage = (ChatMessage.ReqGuildListMessage) getMessage();
        ChatMessage.ResGuildListMessage.Builder builder4Res = ChatMessage.ResGuildListMessage.newBuilder();
    }
}
