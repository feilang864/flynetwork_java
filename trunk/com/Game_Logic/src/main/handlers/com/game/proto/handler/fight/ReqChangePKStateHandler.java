package com.game.proto.handler.fight;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.FightMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqChangePKStateHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqChangePKStateHandler.class);

    @Override
    public void run() {
        // TODO 处理FightMessage.ReqChangePKState消息
        FightMessage.ReqChangePKStateMessage reqMessage = (FightMessage.ReqChangePKStateMessage) getMessage();
        FightMessage.ResChangePKStateMessage.Builder builder4Res = FightMessage.ResChangePKStateMessage.newBuilder();
    }
}
