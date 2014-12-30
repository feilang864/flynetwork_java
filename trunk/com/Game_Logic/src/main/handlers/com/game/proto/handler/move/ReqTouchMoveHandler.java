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
public final class ReqTouchMoveHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqTouchMoveHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqTouchMove消息
        MoveMessage.ReqTouchMoveMessage reqMessage = (MoveMessage.ReqTouchMoveMessage) getMessage();
        MoveMessage.ResTouchMoveMessage.Builder builder4Res = MoveMessage.ResTouchMoveMessage.newBuilder();
    }
}
