package sz.network.socketpool.minapool;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Troy.Chen
 */
public class MinaMessageBean {

    private static final Logger log = Logger.getLogger(MinaMessageBean.class);

    private IoSession ioSession;
    private long msgid;
    private byte[] msgbuffer;

    public MinaMessageBean(IoSession session, long msgid) {
        this.ioSession = session;
        this.msgid = msgid;
    }

    public MinaMessageBean(IoSession session, long msgid, byte[] msgbuffer) {
        this.ioSession = session;
        this.msgid = msgid;
        this.msgbuffer = msgbuffer;
    }

    public long getMsgid() {
        return msgid;
    }

    public byte[] getMsgbuffer() {
        return msgbuffer;
    }

    public void setMsgbuffer(byte[] msgbuffer) {
        this.msgbuffer = msgbuffer;
    }

    public IoSession getIoSession() {
        return ioSession;
    }

    public void setIoSession(IoSession ioSession) {
        this.ioSession = ioSession;
    }

    @Override
    public String toString() {
        return "消息ID<" + msgid + '>';
    }

}
