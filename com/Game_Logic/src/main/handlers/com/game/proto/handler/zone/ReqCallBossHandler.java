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
public final class ReqCallBossHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqCallBossHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqCallBoss消息
        ZoneMessage.ReqCallBossMessage reqMessage = (ZoneMessage.ReqCallBossMessage) getMessage();
        ZoneMessage.ResCallBossMessage.Builder builder4Res = ZoneMessage.ResCallBossMessage.newBuilder();
    }
}
