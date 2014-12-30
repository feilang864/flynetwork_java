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
public final class ReqGuildRemoveJoinHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildRemoveJoinHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildRemoveJoin消息
        ChatMessage.ReqGuildRemoveJoinMessage reqMessage = (ChatMessage.ReqGuildRemoveJoinMessage) getMessage();
        ChatMessage.ResGuildRemoveJoinMessage.Builder builder4Res = ChatMessage.ResGuildRemoveJoinMessage.newBuilder();
    }
}
