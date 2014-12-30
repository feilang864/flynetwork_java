package com.game.proto.handler.mail;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqMailGoodsHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqMailGoodsHandler.class);

    @Override
    public void run() {
        // TODO 处理MailMessage.ReqMailGoods消息
        MailMessage.ReqMailGoodsMessage reqMessage = (MailMessage.ReqMailGoodsMessage) getMessage();
        MailMessage.ResMailGoodsMessage.Builder builder4Res = MailMessage.ResMailGoodsMessage.newBuilder();
    }
}
