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
public final class ReqChangeDirHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqChangeDirHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqChangeDir消息
        MoveMessage.ReqChangeDirMessage reqMessage = (MoveMessage.ReqChangeDirMessage) getMessage();
        MoveMessage.ResChangeDirMessage.Builder builder4Res = MoveMessage.ResChangeDirMessage.newBuilder();
    }
}
