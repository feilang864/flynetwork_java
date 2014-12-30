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
public final class ReqCreateCharacterHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqCreateCharacterHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.ReqCreateCharacter消息
        LoginMessage.ReqCreateCharacterMessage reqMessage = (LoginMessage.ReqCreateCharacterMessage) getMessage();
        LoginMessage.ResCreateCharacterMessage.Builder builder4Res = LoginMessage.ResCreateCharacterMessage.newBuilder();
    }
}
