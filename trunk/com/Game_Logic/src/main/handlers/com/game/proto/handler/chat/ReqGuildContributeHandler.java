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
public final class ReqGuildContributeHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildContributeHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildContribute消息
        ChatMessage.ReqGuildContributeMessage reqMessage = (ChatMessage.ReqGuildContributeMessage) getMessage();
        ChatMessage.ResGuildContributeMessage.Builder builder4Res = ChatMessage.ResGuildContributeMessage.newBuilder();
    }
}
