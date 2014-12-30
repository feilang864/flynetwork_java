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
public final class ReqChatHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqChatHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqChat消息
        ChatMessage.ReqChatMessage reqMessage = (ChatMessage.ReqChatMessage) getMessage();
        ChatMessage.ResChatMessage.Builder builder4Res = ChatMessage.ResChatMessage.newBuilder();
    }
}
