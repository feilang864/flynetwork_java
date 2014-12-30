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
public final class ReqShowBossListHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqShowBossListHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqShowBossList消息
        ZoneMessage.ReqShowBossListMessage reqMessage = (ZoneMessage.ReqShowBossListMessage) getMessage();
        ZoneMessage.ResShowBossListMessage.Builder builder4Res = ZoneMessage.ResShowBossListMessage.newBuilder();
    }
}
