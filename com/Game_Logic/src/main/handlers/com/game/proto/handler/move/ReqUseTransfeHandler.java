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
public final class ReqUseTransfeHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqUseTransfeHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqUseTransfe消息
        MoveMessage.ReqUseTransfeMessage reqMessage = (MoveMessage.ReqUseTransfeMessage) getMessage();
        MoveMessage.ResUseTransfeMessage.Builder builder4Res = MoveMessage.ResUseTransfeMessage.newBuilder();
    }
}
