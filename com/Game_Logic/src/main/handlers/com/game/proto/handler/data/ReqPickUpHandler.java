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
public final class ReqPickUpHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqPickUpHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqPickUp消息
        DataMessage.ReqPickUpMessage reqMessage = (DataMessage.ReqPickUpMessage) getMessage();
        DataMessage.ResPickUpMessage.Builder builder4Res = DataMessage.ResPickUpMessage.newBuilder();
    }
}
