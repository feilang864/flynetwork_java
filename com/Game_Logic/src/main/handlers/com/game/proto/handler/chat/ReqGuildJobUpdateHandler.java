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
public final class ReqGuildJobUpdateHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildJobUpdateHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildJobUpdate消息
        ChatMessage.ReqGuildJobUpdateMessage reqMessage = (ChatMessage.ReqGuildJobUpdateMessage) getMessage();
        ChatMessage.ResGuildJobUpdateMessage.Builder builder4Res = ChatMessage.ResGuildJobUpdateMessage.newBuilder();
    }
}
