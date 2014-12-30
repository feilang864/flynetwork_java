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
public final class ReqBackpackListHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqBackpackListHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqBackpackList消息
        DataMessage.ReqBackpackListMessage reqMessage = (DataMessage.ReqBackpackListMessage) getMessage();
        DataMessage.ResBackpackListMessage.Builder builder4Res = DataMessage.ResBackpackListMessage.newBuilder();
    }
}
