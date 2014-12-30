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
public final class ReqGuildBaseInfoHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildBaseInfoHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildBaseInfo消息
        ChatMessage.ReqGuildBaseInfoMessage reqMessage = (ChatMessage.ReqGuildBaseInfoMessage) getMessage();
        ChatMessage.ResGuildBaseInfoMessage.Builder builder4Res = ChatMessage.ResGuildBaseInfoMessage.newBuilder();
    }
}
