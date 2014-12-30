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
public final class ReqZoneLotteryCloseHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqZoneLotteryCloseHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqZoneLotteryClose消息
        ZoneMessage.ReqZoneLotteryCloseMessage reqMessage = (ZoneMessage.ReqZoneLotteryCloseMessage) getMessage();
        ZoneMessage.ResZoneLotteryCloseMessage.Builder builder4Res = ZoneMessage.ResZoneLotteryCloseMessage.newBuilder();
    }
}
