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
public final class ReqGuildMoneyTreeHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildMoneyTreeHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildMoneyTree消息
        ChatMessage.ReqGuildMoneyTreeMessage reqMessage = (ChatMessage.ReqGuildMoneyTreeMessage) getMessage();
        ChatMessage.ResGuildMoneyTreeMessage.Builder builder4Res = ChatMessage.ResGuildMoneyTreeMessage.newBuilder();
    }
}
