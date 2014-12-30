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
public final class ReqSelectAwardHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqSelectAwardHandler.class);

    @Override
    public void run() {
        // TODO 处理ZoneMessage.ReqSelectAward消息
        ZoneMessage.ReqSelectAwardMessage reqMessage = (ZoneMessage.ReqSelectAwardMessage) getMessage();
        ZoneMessage.ResSelectAwardMessage.Builder builder4Res = ZoneMessage.ResSelectAwardMessage.newBuilder();
    }
}
