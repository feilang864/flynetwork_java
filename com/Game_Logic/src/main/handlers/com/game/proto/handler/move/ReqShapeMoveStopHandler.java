package com.game.proto.handler.move;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.MoveMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqShapeMoveStopHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqShapeMoveStopHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqShapeMoveStop消息
        MoveMessage.ReqShapeMoveStopMessage reqMessage = (MoveMessage.ReqShapeMoveStopMessage) getMessage();
        MoveMessage.ResShapeMoveStopMessage.Builder builder4Res = MoveMessage.ResShapeMoveStopMessage.newBuilder();
    }
}
