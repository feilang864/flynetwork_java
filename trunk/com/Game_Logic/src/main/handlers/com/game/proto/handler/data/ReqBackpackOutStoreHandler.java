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
public final class ReqBackpackOutStoreHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqBackpackOutStoreHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqBackpackOutStore消息
        DataMessage.ReqBackpackOutStoreMessage reqMessage = (DataMessage.ReqBackpackOutStoreMessage) getMessage();
        DataMessage.ResBackpackOutStoreMessage.Builder builder4Res = DataMessage.ResBackpackOutStoreMessage.newBuilder();
    }
}
