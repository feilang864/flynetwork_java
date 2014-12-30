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
public final class ReqUseGoodBackpackHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqUseGoodBackpackHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqUseGoodBackpack消息
        DataMessage.ReqUseGoodBackpackMessage reqMessage = (DataMessage.ReqUseGoodBackpackMessage) getMessage();
        DataMessage.ResUseGoodBackpackMessage.Builder builder4Res = DataMessage.ResUseGoodBackpackMessage.newBuilder();
    }
}
