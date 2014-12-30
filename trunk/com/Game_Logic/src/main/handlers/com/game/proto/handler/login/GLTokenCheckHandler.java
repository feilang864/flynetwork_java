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
public final class GLTokenCheckHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(GLTokenCheckHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.GLTokenCheck消息
        LoginMessage.GLTokenCheckMessage reqMessage = (LoginMessage.GLTokenCheckMessage) getMessage();
        LoginMessage.LGTokenCheckMessage.Builder builder4Res = LoginMessage.LGTokenCheckMessage.newBuilder();
    }
}
