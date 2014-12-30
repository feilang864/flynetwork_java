package com.game.proto.handler.task;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.TaskMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqTouchNpcHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqTouchNpcHandler.class);

    @Override
    public void run() {
        // TODO 处理TaskMessage.ReqTouchNpc消息
        TaskMessage.ReqTouchNpcMessage reqMessage = (TaskMessage.ReqTouchNpcMessage) getMessage();
        TaskMessage.ResTouchNpcMessage.Builder builder4Res = TaskMessage.ResTouchNpcMessage.newBuilder();
    }
}
