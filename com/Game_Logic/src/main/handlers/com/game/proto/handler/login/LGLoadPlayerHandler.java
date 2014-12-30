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
public final class LGLoadPlayerHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(LGLoadPlayerHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.LGLoadPlayer消息
        LoginMessage.LGLoadPlayerMessage reqMessage = (LoginMessage.LGLoadPlayerMessage) getMessage();
        LoginMessage.GLLoadPlayerMessage.Builder builder4Res = LoginMessage.GLLoadPlayerMessage.newBuilder();
    }
}
