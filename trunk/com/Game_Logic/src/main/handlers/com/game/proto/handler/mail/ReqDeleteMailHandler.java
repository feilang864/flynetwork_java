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
public final class ReqDeleteMailHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqDeleteMailHandler.class);

    @Override
    public void run() {
        // TODO 处理MailMessage.ReqDeleteMail消息
        MailMessage.ReqDeleteMailMessage reqMessage = (MailMessage.ReqDeleteMailMessage) getMessage();
        MailMessage.ResDeleteMailMessage.Builder builder4Res = MailMessage.ResDeleteMailMessage.newBuilder();
    }
}
