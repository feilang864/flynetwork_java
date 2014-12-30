package com.game.proto.handler.registerlogin;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.RegisterLoginMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class GLRegisterLoginHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(GLRegisterLoginHandler.class);

    @Override
    public void run() {
        // TODO 处理RegisterLoginMessage.GLRegisterLogin消息
        RegisterLoginMessage.GLRegisterLoginMessage reqMessage = (RegisterLoginMessage.GLRegisterLoginMessage) getMessage();
        RegisterLoginMessage.LGRegisterLoginMessage.Builder builder4Res = RegisterLoginMessage.LGRegisterLoginMessage.newBuilder();
    }
}
