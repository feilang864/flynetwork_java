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
public final class ReqObjRefineHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqObjRefineHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqObjRefine消息
        EquipmentMessage.ReqObjRefineMessage reqMessage = (EquipmentMessage.ReqObjRefineMessage) getMessage();
        EquipmentMessage.ResObjRefineMessage.Builder builder4Res = EquipmentMessage.ResObjRefineMessage.newBuilder();
    }
}
