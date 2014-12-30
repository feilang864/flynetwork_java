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
public final class ReqComposeHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqComposeHandler.class);

    @Override
    public void run() {
        // TODO 处理EquipmentMessage.ReqCompose消息
        EquipmentMessage.ReqComposeMessage reqMessage = (EquipmentMessage.ReqComposeMessage) getMessage();
        EquipmentMessage.ResComposeMessage.Builder builder4Res = EquipmentMessage.ResComposeMessage.newBuilder();
    }
}
