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
public final class ReqZoneLotteryHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqZoneLotteryHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqZoneLottery消息
        ZoneMessage.ReqZoneLotteryMessage reqMessage = (ZoneMessage.ReqZoneLotteryMessage) getMessage();
        ZoneMessage.ResZoneLotteryMessage.Builder builder4Res = ZoneMessage.ResZoneLotteryMessage.newBuilder();
    }
}
