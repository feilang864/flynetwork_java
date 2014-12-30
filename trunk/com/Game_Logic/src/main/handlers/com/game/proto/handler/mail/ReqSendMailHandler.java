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
public final class ReqSendMailHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqSendMailHandler.class);

    @Override
    public void run() {
        // TODO 处理MailMessage.ReqSendMail消息
        MailMessage.ReqSendMailMessage reqMessage = (MailMessage.ReqSendMailMessage) getMessage();
        MailMessage.ResSendMailMessage.Builder builder4Res = MailMessage.ResSendMailMessage.newBuilder();
    }
}
