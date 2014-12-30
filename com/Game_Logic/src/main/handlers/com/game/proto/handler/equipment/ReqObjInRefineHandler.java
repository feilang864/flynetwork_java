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
public final class ReqObjInRefineHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqObjInRefineHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqObjInRefine消息
        EquipmentMessage.ReqObjInRefineMessage reqMessage = (EquipmentMessage.ReqObjInRefineMessage) getMessage();
        EquipmentMessage.ResObjInRefineMessage.Builder builder4Res = EquipmentMessage.ResObjInRefineMessage.newBuilder();
    }
}
