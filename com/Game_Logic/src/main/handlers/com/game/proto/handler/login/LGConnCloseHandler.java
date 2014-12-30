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
public final class LGConnCloseHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(LGConnCloseHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.LGConnClose消息
        LoginMessage.LGConnCloseMessage reqMessage = (LoginMessage.LGConnCloseMessage) getMessage();
        LoginMessage.GLConnCloseMessage.Builder builder4Res = LoginMessage.GLConnCloseMessage.newBuilder();
    }
}
