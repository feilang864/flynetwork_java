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
public final class ReqReadMailHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqReadMailHandler.class);

    @Override
    public void run() {
        // TODO 处理MailMessage.ReqReadMail消息
        MailMessage.ReqReadMailMessage reqMessage = (MailMessage.ReqReadMailMessage) getMessage();
        MailMessage.ResReadMailMessage.Builder builder4Res = MailMessage.ResReadMailMessage.newBuilder();
    }
}
