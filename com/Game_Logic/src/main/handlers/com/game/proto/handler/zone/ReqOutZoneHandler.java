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
public final class ReqOutZoneHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqOutZoneHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqOutZone消息
        ZoneMessage.ReqOutZoneMessage reqMessage = (ZoneMessage.ReqOutZoneMessage) getMessage();
        ZoneMessage.ResOutZoneMessage.Builder builder4Res = ZoneMessage.ResOutZoneMessage.newBuilder();
    }
}
