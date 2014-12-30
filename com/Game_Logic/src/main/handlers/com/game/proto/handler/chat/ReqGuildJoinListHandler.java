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
public final class ReqGuildJoinListHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildJoinListHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildJoinList消息
        ChatMessage.ReqGuildJoinListMessage reqMessage = (ChatMessage.ReqGuildJoinListMessage) getMessage();
        ChatMessage.ResGuildJoinListMessage.Builder builder4Res = ChatMessage.ResGuildJoinListMessage.newBuilder();
    }
}
