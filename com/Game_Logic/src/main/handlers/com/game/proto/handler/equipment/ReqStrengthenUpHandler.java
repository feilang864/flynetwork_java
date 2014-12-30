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
public final class ReqStrengthenUpHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqStrengthenUpHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqStrengthenUp消息
        EquipmentMessage.ReqStrengthenUpMessage reqMessage = (EquipmentMessage.ReqStrengthenUpMessage) getMessage();
        EquipmentMessage.ResStrengthenUpMessage.Builder builder4Res = EquipmentMessage.ResStrengthenUpMessage.newBuilder();
    }
}
