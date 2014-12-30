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
public final class ReqGuildDrawCardHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildDrawCardHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildDrawCard消息
        ChatMessage.ReqGuildDrawCardMessage reqMessage = (ChatMessage.ReqGuildDrawCardMessage) getMessage();
        ChatMessage.ResGuildDrawCardMessage.Builder builder4Res = ChatMessage.ResGuildDrawCardMessage.newBuilder();
    }
}
