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
public final class ReqRefineMakeSureHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqRefineMakeSureHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqRefineMakeSure消息
        EquipmentMessage.ReqRefineMakeSureMessage reqMessage = (EquipmentMessage.ReqRefineMakeSureMessage) getMessage();
        EquipmentMessage.ResRefineMakeSureMessage.Builder builder4Res = EquipmentMessage.ResRefineMakeSureMessage.newBuilder();
    }
}
