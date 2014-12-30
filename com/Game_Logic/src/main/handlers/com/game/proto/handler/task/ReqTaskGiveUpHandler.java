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
public final class ReqTaskGiveUpHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqTaskGiveUpHandler.class);

    @Override
    public void run() {
        // TODO 处理TaskMessage.ReqTaskGiveUp消息
        TaskMessage.ReqTaskGiveUpMessage reqMessage = (TaskMessage.ReqTaskGiveUpMessage) getMessage();
        TaskMessage.ResTaskGiveUpMessage.Builder builder4Res = TaskMessage.ResTaskGiveUpMessage.newBuilder();
    }
}
