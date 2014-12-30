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
public final class ReqSelectPlayerAttributeHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqSelectPlayerAttributeHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqSelectPlayerAttribute消息
        DataMessage.ReqSelectPlayerAttributeMessage reqMessage = (DataMessage.ReqSelectPlayerAttributeMessage) getMessage();
        DataMessage.ResSelectPlayerAttributeMessage.Builder builder4Res = DataMessage.ResSelectPlayerAttributeMessage.newBuilder();
    }
}
