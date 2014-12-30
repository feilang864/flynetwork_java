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
public final class ReqClearUpBackpackHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqClearUpBackpackHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqClearUpBackpack消息
        DataMessage.ReqClearUpBackpackMessage reqMessage = (DataMessage.ReqClearUpBackpackMessage) getMessage();
        DataMessage.ResClearUpBackpackMessage.Builder builder4Res = DataMessage.ResClearUpBackpackMessage.newBuilder();
    }
}
