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
public final class ReqChangeLineHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqChangeLineHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqChangeLine消息
        MoveMessage.ReqChangeLineMessage reqMessage = (MoveMessage.ReqChangeLineMessage) getMessage();
        MoveMessage.ResChangeLineMessage.Builder builder4Res = MoveMessage.ResChangeLineMessage.newBuilder();
    }
}
