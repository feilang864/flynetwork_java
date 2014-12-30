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
public final class ReqUseFlyHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqUseFlyHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqUseFly消息
        MoveMessage.ReqUseFlyMessage reqMessage = (MoveMessage.ReqUseFlyMessage) getMessage();
        MoveMessage.ResUseFlyMessage.Builder builder4Res = MoveMessage.ResUseFlyMessage.newBuilder();
    }
}
