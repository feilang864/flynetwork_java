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
public final class ReqGuildJoinHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildJoinHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildJoin消息
        ChatMessage.ReqGuildJoinMessage reqMessage = (ChatMessage.ReqGuildJoinMessage) getMessage();
        ChatMessage.ResGuildJoinMessage.Builder builder4Res = ChatMessage.ResGuildJoinMessage.newBuilder();
    }
}
