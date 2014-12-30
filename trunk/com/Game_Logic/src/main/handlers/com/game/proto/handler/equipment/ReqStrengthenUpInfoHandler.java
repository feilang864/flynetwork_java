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
public final class ReqStrengthenUpInfoHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqStrengthenUpInfoHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqStrengthenUpInfo消息
        EquipmentMessage.ReqStrengthenUpInfoMessage reqMessage = (EquipmentMessage.ReqStrengthenUpInfoMessage) getMessage();
        EquipmentMessage.ResStrengthenUpInfoMessage.Builder builder4Res = EquipmentMessage.ResStrengthenUpInfoMessage.newBuilder();
    }
}
