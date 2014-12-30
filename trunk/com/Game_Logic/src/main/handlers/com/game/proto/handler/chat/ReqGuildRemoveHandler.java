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
public final class ReqGuildRemoveHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildRemoveHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildRemove消息
        ChatMessage.ReqGuildRemoveMessage reqMessage = (ChatMessage.ReqGuildRemoveMessage) getMessage();
        ChatMessage.ResGuildRemoveMessage.Builder builder4Res = ChatMessage.ResGuildRemoveMessage.newBuilder();
    }
}
