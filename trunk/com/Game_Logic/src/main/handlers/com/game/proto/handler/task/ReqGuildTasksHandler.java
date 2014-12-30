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
public final class ReqGuildTasksHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqGuildTasksHandler.class);

    @Override
    public void run() {
        // TODO 处理TaskMessage.ReqGuildTasks消息
        TaskMessage.ReqGuildTasksMessage reqMessage = (TaskMessage.ReqGuildTasksMessage) getMessage();
        TaskMessage.ResGuildTasksMessage.Builder builder4Res = TaskMessage.ResGuildTasksMessage.newBuilder();
    }
}
