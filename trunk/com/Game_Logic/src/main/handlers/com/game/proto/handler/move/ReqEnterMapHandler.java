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
public final class ReqEnterMapHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqEnterMapHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqEnterMap消息
        MoveMessage.ReqEnterMapMessage reqMessage = (MoveMessage.ReqEnterMapMessage) getMessage();
        MoveMessage.ResEnterMapMessage.Builder builder4Res = MoveMessage.ResEnterMapMessage.newBuilder();
    }
}
