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
public final class GLUpdateServerInfoHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(GLUpdateServerInfoHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.GLUpdateServerInfo消息
        LoginMessage.GLUpdateServerInfoMessage reqMessage = (LoginMessage.GLUpdateServerInfoMessage) getMessage();
        LoginMessage.LGUpdateServerInfoMessage.Builder builder4Res = LoginMessage.LGUpdateServerInfoMessage.newBuilder();
    }
}
