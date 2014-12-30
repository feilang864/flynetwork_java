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
public final class LDRegisterLoginHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(LDRegisterLoginHandler.class);

    @Override
    public void run() {
        // TODO 处理RegisterLoginMessage.LDRegisterLogin消息
        RegisterLoginMessage.LDRegisterLoginMessage reqMessage = (RegisterLoginMessage.LDRegisterLoginMessage) getMessage();
        RegisterLoginMessage.DLRegisterLoginMessage.Builder builder4Res = RegisterLoginMessage.DLRegisterLoginMessage.newBuilder();
    }
}
