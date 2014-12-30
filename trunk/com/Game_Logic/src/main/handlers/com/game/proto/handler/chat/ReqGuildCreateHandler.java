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
public final class ReqGuildCreateHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildCreateHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildCreate消息
        ChatMessage.ReqGuildCreateMessage reqMessage = (ChatMessage.ReqGuildCreateMessage) getMessage();
        ChatMessage.ResGuildCreateMessage.Builder builder4Res = ChatMessage.ResGuildCreateMessage.newBuilder();
    }
}