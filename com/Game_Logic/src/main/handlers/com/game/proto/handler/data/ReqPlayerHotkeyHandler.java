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
public final class ReqPlayerHotkeyHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqPlayerHotkeyHandler.class);

    @Override
    public void run() {
        // TODO 处理DataMessage.ReqPlayerHotkey消息
        DataMessage.ReqPlayerHotkeyMessage reqMessage = (DataMessage.ReqPlayerHotkeyMessage) getMessage();
        DataMessage.ResPlayerHotkeyMessage.Builder builder4Res = DataMessage.ResPlayerHotkeyMessage.newBuilder();
    }
}
