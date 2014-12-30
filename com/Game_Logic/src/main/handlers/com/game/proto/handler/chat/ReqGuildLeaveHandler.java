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
public final class ReqGuildLeaveHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildLeaveHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildLeave消息
        ChatMessage.ReqGuildLeaveMessage reqMessage = (ChatMessage.ReqGuildLeaveMessage) getMessage();
        ChatMessage.ResGuildLeaveMessage.Builder builder4Res = ChatMessage.ResGuildLeaveMessage.newBuilder();
    }
}
