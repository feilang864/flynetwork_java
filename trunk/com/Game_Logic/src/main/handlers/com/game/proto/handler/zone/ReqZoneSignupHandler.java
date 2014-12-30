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
public final class ReqZoneSignupHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqZoneSignupHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqZoneSignup消息
        ZoneMessage.ReqZoneSignupMessage reqMessage = (ZoneMessage.ReqZoneSignupMessage) getMessage();
        ZoneMessage.ResZoneSignupMessage.Builder builder4Res = ZoneMessage.ResZoneSignupMessage.newBuilder();
    }
}
