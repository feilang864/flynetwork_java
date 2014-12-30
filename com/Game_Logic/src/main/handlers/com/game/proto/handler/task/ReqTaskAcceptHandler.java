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
public final class ReqTaskAcceptHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqTaskAcceptHandler.class);

    @Override
    public void run() {
        // TODO 处理TaskMessage.ReqTaskAccept消息
        TaskMessage.ReqTaskAcceptMessage reqMessage = (TaskMessage.ReqTaskAcceptMessage) getMessage();
        TaskMessage.ResTaskAcceptMessage.Builder builder4Res = TaskMessage.ResTaskAcceptMessage.newBuilder();
    }
}
