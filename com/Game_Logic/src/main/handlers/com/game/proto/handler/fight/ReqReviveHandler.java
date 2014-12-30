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
public final class ReqReviveHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqReviveHandler.class);

    @Override
    public void run() {
        // TODO 处理FightMessage.ReqRevive消息
        FightMessage.ReqReviveMessage reqMessage = (FightMessage.ReqReviveMessage) getMessage();
        FightMessage.ResReviveMessage.Builder builder4Res = FightMessage.ResReviveMessage.newBuilder();
    }
}
