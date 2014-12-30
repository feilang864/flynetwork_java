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
public final class ReqGuildReplyJoinHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildReplyJoinHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildReplyJoin消息
        ChatMessage.ReqGuildReplyJoinMessage reqMessage = (ChatMessage.ReqGuildReplyJoinMessage) getMessage();
        ChatMessage.ResGuildReplyJoinMessage.Builder builder4Res = ChatMessage.ResGuildReplyJoinMessage.newBuilder();
    }
}
