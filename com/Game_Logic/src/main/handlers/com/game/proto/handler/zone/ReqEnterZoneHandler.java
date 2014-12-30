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
public final class ReqEnterZoneHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqEnterZoneHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqEnterZone消息
        ZoneMessage.ReqEnterZoneMessage reqMessage = (ZoneMessage.ReqEnterZoneMessage) getMessage();
        ZoneMessage.ResEnterZoneMessage.Builder builder4Res = ZoneMessage.ResEnterZoneMessage.newBuilder();
    }
}
