package sz.network.socketpool.minapool;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * 解码器
 */
public class BufferMarshalDecoder implements ProtocolDecoder {

    private static final Logger log = Logger.getLogger(BufferMarshalDecoder.class);

    private static final String CONTEXT = "context";
    private static final String START_TIME = "start_time";
    private static final String RECEIVE_COUNT = "receive_count";

//    private static final int MAX_SIZE = 10240;
//    private static final int MAX_COUNT = 30;
    public BufferMarshalDecoder() {

    }

    // 解码
    @Override
    public void decode(IoSession session, IoBuffer buff, ProtocolDecoderOutput out)
            throws Exception {
        long startTime = 0L;
        if (session.containsAttribute(START_TIME)) {
            startTime = (long) session.getAttribute(START_TIME);
        }
        int count = 0;
        if (session.containsAttribute(RECEIVE_COUNT)) {
            count = (int) session.getAttribute(RECEIVE_COUNT);
        }
        if (System.currentTimeMillis() - startTime > 1000L) {
            if (count > 10) {
                log.error(session + " --> 消息过于频繁:" + count + "\t" + session);
            }
            startTime = System.currentTimeMillis();
            count = 0;
        }
        count++;
        if (count > 4 * 1024) { // MAX_COUNT
            log.error(" 消息长度过大:" + count);
            return;
        }

        session.setAttribute(START_TIME, startTime);
        session.setAttribute(RECEIVE_COUNT, count);

    }

    @Override
    public void dispose(IoSession session)
            throws Exception {
        if (session.getAttribute(CONTEXT) != null) {
            session.removeAttribute(CONTEXT);
        }
    }

    /**
     * 可以用于处理在 IoSession 关闭时剩余的未读取数据
     *
     * @param session
     * @param out
     * @throws Exception
     */
    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out)
            throws Exception {
    }
}
