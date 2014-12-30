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
public final class GLConnCloseHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(GLConnCloseHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.GLConnClose消息
        LoginMessage.GLConnCloseMessage reqMessage = (LoginMessage.GLConnCloseMessage) getMessage();
        LoginMessage.LGConnCloseMessage.Builder builder4Res = LoginMessage.LGConnCloseMessage.newBuilder();
    }
}
