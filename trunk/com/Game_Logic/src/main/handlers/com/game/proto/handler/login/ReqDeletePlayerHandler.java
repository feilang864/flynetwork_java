package com.game.proto.handler.login;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.LoginMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqDeletePlayerHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqDeletePlayerHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.ReqDeletePlayer消息
        LoginMessage.ReqDeletePlayerMessage reqMessage = (LoginMessage.ReqDeletePlayerMessage) getMessage();
        LoginMessage.ResDeletePlayerMessage.Builder builder4Res = LoginMessage.ResDeletePlayerMessage.newBuilder();
    }
}
