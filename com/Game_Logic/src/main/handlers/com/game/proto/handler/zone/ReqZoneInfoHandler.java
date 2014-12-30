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
public final class ReqZoneInfoHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqZoneInfoHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqZoneInfo消息
        ZoneMessage.ReqZoneInfoMessage reqMessage = (ZoneMessage.ReqZoneInfoMessage) getMessage();
        ZoneMessage.ResZoneInfoMessage.Builder builder4Res = ZoneMessage.ResZoneInfoMessage.newBuilder();
    }
}
