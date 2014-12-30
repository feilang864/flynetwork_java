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
public final class ReqBlockCheckHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqBlockCheckHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqBlockCheck消息
        MoveMessage.ReqBlockCheckMessage reqMessage = (MoveMessage.ReqBlockCheckMessage) getMessage();
        MoveMessage.ResBlockCheckMessage.Builder builder4Res = MoveMessage.ResBlockCheckMessage.newBuilder();
    }
}
