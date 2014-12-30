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
public final class ReqSyncPosHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqSyncPosHandler.class);

    @Override
    public void run() {
        // TODO 处理MoveMessage.ReqSyncPos消息
        MoveMessage.ReqSyncPosMessage reqMessage = (MoveMessage.ReqSyncPosMessage) getMessage();
        MoveMessage.ResSyncPosMessage.Builder builder4Res = MoveMessage.ResSyncPosMessage.newBuilder();
    }
}
