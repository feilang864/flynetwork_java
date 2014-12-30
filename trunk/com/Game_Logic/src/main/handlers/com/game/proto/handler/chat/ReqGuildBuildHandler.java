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
public final class ReqGuildBuildHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildBuildHandler.class);

    @Override
    public void run() {
        // TODO 处理ChatMessage.ReqGuildBuild消息
        ChatMessage.ReqGuildBuildMessage reqMessage = (ChatMessage.ReqGuildBuildMessage) getMessage();
        ChatMessage.ResGuildBuildMessage.Builder builder4Res = ChatMessage.ResGuildBuildMessage.newBuilder();
    }
}
