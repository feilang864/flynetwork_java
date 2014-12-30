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
public final class ReqMapLinesHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqMapLinesHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqMapLines消息
        MoveMessage.ReqMapLinesMessage reqMessage = (MoveMessage.ReqMapLinesMessage) getMessage();
        MoveMessage.ResMapLinesMessage.Builder builder4Res = MoveMessage.ResMapLinesMessage.newBuilder();
    }
}
