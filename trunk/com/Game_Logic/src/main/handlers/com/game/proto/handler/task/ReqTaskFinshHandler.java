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
public final class ReqTaskFinshHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqTaskFinshHandler.class);

    @Override
    public void run() {
        // TODO 处理TaskMessage.ReqTaskFinsh消息
        TaskMessage.ReqTaskFinshMessage reqMessage = (TaskMessage.ReqTaskFinshMessage) getMessage();
        TaskMessage.ResTaskFinshMessage.Builder builder4Res = TaskMessage.ResTaskFinshMessage.newBuilder();
    }
}
