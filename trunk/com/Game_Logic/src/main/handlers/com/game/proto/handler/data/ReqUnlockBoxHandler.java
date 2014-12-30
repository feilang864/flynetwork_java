package com.game.proto.handler.data;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.DataMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqUnlockBoxHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqUnlockBoxHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqUnlockBox消息
        DataMessage.ReqUnlockBoxMessage reqMessage = (DataMessage.ReqUnlockBoxMessage) getMessage();
        DataMessage.ResUnlockBoxMessage.Builder builder4Res = DataMessage.ResUnlockBoxMessage.newBuilder();
    }
}
