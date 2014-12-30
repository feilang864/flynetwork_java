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
public final class ReqHeartBeatHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqHeartBeatHandler.class);

    @Override
    public void run() {
        // TODO 处理LoginMessage.ReqHeartBeat消息
        LoginMessage.ReqHeartBeatMessage reqMessage = (LoginMessage.ReqHeartBeatMessage) getMessage();
        LoginMessage.ResHeartBeatMessage.Builder builder4Res = LoginMessage.ResHeartBeatMessage.newBuilder();
    }
}
