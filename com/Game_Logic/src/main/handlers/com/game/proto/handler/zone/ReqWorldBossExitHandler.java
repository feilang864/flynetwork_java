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
public final class ReqWorldBossExitHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqWorldBossExitHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqWorldBossExit消息
        ZoneMessage.ReqWorldBossExitMessage reqMessage = (ZoneMessage.ReqWorldBossExitMessage) getMessage();
        ZoneMessage.ResWorldBossExitMessage.Builder builder4Res = ZoneMessage.ResWorldBossExitMessage.newBuilder();
    }
}
