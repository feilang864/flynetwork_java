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
public final class ReqBackpackInStoreHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqBackpackInStoreHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqBackpackInStore消息
        DataMessage.ReqBackpackInStoreMessage reqMessage = (DataMessage.ReqBackpackInStoreMessage) getMessage();
        DataMessage.ResBackpackInStoreMessage.Builder builder4Res = DataMessage.ResBackpackInStoreMessage.newBuilder();
    }
}
