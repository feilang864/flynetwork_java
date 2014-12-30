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
public final class ReqShapeMoveHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqShapeMoveHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqShapeMove消息
        MoveMessage.ReqShapeMoveMessage reqMessage = (MoveMessage.ReqShapeMoveMessage) getMessage();
        MoveMessage.ResShapeMoveMessage.Builder builder4Res = MoveMessage.ResShapeMoveMessage.newBuilder();
    }
}
