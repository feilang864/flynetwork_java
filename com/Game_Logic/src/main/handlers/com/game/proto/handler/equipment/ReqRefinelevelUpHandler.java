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
public final class ReqRefinelevelUpHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqRefinelevelUpHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqRefinelevelUp消息
        EquipmentMessage.ReqRefinelevelUpMessage reqMessage = (EquipmentMessage.ReqRefinelevelUpMessage) getMessage();
        EquipmentMessage.ResRefinelevelUpMessage.Builder builder4Res = EquipmentMessage.ResRefinelevelUpMessage.newBuilder();
    }
}
