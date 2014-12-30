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
public final class LGRegisterLoginHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(LGRegisterLoginHandler.class);

    @Override
    public void run() {
        // TODO 处理RegisterLoginMessage.LGRegisterLogin消息
        RegisterLoginMessage.LGRegisterLoginMessage reqMessage = (RegisterLoginMessage.LGRegisterLoginMessage) getMessage();
        RegisterLoginMessage.GLRegisterLoginMessage.Builder builder4Res = RegisterLoginMessage.GLRegisterLoginMessage.newBuilder();
    }
}
