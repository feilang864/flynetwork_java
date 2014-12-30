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
public final class ReqZoneActivitiesHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqZoneActivitiesHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqZoneActivities消息
        ZoneMessage.ReqZoneActivitiesMessage reqMessage = (ZoneMessage.ReqZoneActivitiesMessage) getMessage();
        ZoneMessage.ResZoneActivitiesMessage.Builder builder4Res = ZoneMessage.ResZoneActivitiesMessage.newBuilder();
    }
}
