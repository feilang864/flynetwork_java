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
public final class ReqSelectPlayerHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqSelectPlayerHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.ReqSelectPlayer消息
        LoginMessage.ReqSelectPlayerMessage reqMessage = (LoginMessage.ReqSelectPlayerMessage) getMessage();
        LoginMessage.ResSelectPlayerMessage.Builder builder4Res = LoginMessage.ResSelectPlayerMessage.newBuilder();
    }
}
