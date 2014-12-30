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
public final class ReqEnterGuildZoneHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqEnterGuildZoneHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqEnterGuildZone消息
        ZoneMessage.ReqEnterGuildZoneMessage reqMessage = (ZoneMessage.ReqEnterGuildZoneMessage) getMessage();
        ZoneMessage.ResEnterGuildZoneMessage.Builder builder4Res = ZoneMessage.ResEnterGuildZoneMessage.newBuilder();
    }
}
