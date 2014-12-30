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
public final class ReqDailyTasksHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqDailyTasksHandler.class);

    @Override
    public void run() {
        // TODO 处理TaskMessage.ReqDailyTasks消息
        TaskMessage.ReqDailyTasksMessage reqMessage = (TaskMessage.ReqDailyTasksMessage) getMessage();
        TaskMessage.ResDailyTasksMessage.Builder builder4Res = TaskMessage.ResDailyTasksMessage.newBuilder();
    }
}
