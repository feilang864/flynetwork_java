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
public final class ReqLoadFinishHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqLoadFinishHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.ReqLoadFinish消息
        LoginMessage.ReqLoadFinishMessage reqMessage = (LoginMessage.ReqLoadFinishMessage) getMessage();
        LoginMessage.ResLoadFinishMessage.Builder builder4Res = LoginMessage.ResLoadFinishMessage.newBuilder();
    }
}