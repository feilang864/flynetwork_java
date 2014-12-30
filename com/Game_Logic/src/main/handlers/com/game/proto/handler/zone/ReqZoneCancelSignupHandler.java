package com.game.proto.handler.zone;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.ZoneMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqZoneCancelSignupHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqZoneCancelSignupHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqZoneCancelSignup消息
        ZoneMessage.ReqZoneCancelSignupMessage reqMessage = (ZoneMessage.ReqZoneCancelSignupMessage) getMessage();
        ZoneMessage.ResZoneCancelSignupMessage.Builder builder4Res = ZoneMessage.ResZoneCancelSignupMessage.newBuilder();
    }
}
