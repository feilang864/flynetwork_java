package com.game.proto.handler.equipment;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.EquipmentMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqPunchHoleHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqPunchHoleHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqPunchHole消息
        EquipmentMessage.ReqPunchHoleMessage reqMessage = (EquipmentMessage.ReqPunchHoleMessage) getMessage();
        EquipmentMessage.ResPunchHoleMessage.Builder builder4Res = EquipmentMessage.ResPunchHoleMessage.newBuilder();
    }
}
