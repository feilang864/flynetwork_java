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
public final class ReqGuildBuffHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildBuffHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildBuff消息
        ChatMessage.ReqGuildBuffMessage reqMessage = (ChatMessage.ReqGuildBuffMessage) getMessage();
        ChatMessage.ResGuildBuffMessage.Builder builder4Res = ChatMessage.ResGuildBuffMessage.newBuilder();
    }
}
