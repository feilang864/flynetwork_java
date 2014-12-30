package com.game.proto.handler.data;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.DataMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqPlayerRemoveEquipHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqPlayerRemoveEquipHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqPlayerRemoveEquip消息
        DataMessage.ReqPlayerRemoveEquipMessage reqMessage = (DataMessage.ReqPlayerRemoveEquipMessage) getMessage();
        DataMessage.ResPlayerRemoveEquipMessage.Builder builder4Res = DataMessage.ResPlayerRemoveEquipMessage.newBuilder();
    }
}
