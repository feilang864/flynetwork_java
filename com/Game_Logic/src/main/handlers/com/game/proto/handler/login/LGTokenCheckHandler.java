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
public final class LGTokenCheckHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(LGTokenCheckHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.LGTokenCheck消息
        LoginMessage.LGTokenCheckMessage reqMessage = (LoginMessage.LGTokenCheckMessage) getMessage();
        LoginMessage.GLTokenCheckMessage.Builder builder4Res = LoginMessage.GLTokenCheckMessage.newBuilder();
    }
}
