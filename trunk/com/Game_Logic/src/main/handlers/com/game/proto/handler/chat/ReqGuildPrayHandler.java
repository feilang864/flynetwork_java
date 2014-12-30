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
public final class ReqGuildPrayHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildPrayHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildPray消息
        ChatMessage.ReqGuildPrayMessage reqMessage = (ChatMessage.ReqGuildPrayMessage) getMessage();
        ChatMessage.ResGuildPrayMessage.Builder builder4Res = ChatMessage.ResGuildPrayMessage.newBuilder();
    }
}
