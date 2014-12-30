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
public final class ReqGuildInviteAnswerHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildInviteAnswerHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildInviteAnswer消息
        ChatMessage.ReqGuildInviteAnswerMessage reqMessage = (ChatMessage.ReqGuildInviteAnswerMessage) getMessage();
        ChatMessage.ResGuildInviteAnswerMessage.Builder builder4Res = ChatMessage.ResGuildInviteAnswerMessage.newBuilder();
    }
}
