package com.game.main;

import com.game.main.msgaction.MsgAction;
import com.game.proto.LoginMessage;
import com.google.protobuf.Message;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 */
public class ServerProtocolDecoder
        implements ProtocolDecoder {

    private static final Logger log = LoggerFactory.getLogger(ServerProtocolDecoder.class);

    private static final String CONTEXT = "context";
    private static final String START_TIME = "start_time";
    private static final String RECEIVE_COUNT = "receive_count";

    private static final int MAX_SIZE = 10240;
    private static final int MAX_COUNT = 30;

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
                log.error(session + " --> sendmsg:" + count);
            }
            startTime = System.currentTimeMillis();
            count = 0;
        }
        count++;
        if (count > MAX_COUNT) {
            SessionUtil.close(session, "--> sendmsg:%d -->close-->buf:%d(%s)", count, buff.remaining(), buff.toString());
            return;
        }

        session.setAttribute(START_TIME, startTime);
        session.setAttribute(RECEIVE_COUNT, count);

        ServerContext context = null;
        if (session.getAttribute(CONTEXT) != null) {
            context = (ServerContext) session.getAttribute(CONTEXT);
        }
        if (context == null) {
            context = new ServerContext();
            session.setAttribute(CONTEXT, context);
        }

        IoBuffer contextBuff = context.getBuff();
        contextBuff.put(buff);

        for (;;) {
            contextBuff.flip();
            if (contextBuff.remaining() < 4) {
                contextBuff.compact();
                break;
            }
            int length = contextBuff.getInt();
            if (length > MAX_SIZE) {
                SessionUtil.close(session, "--> 数据包长度超过限制:%d -->close-->buf:%d(%s)", length, buff.remaining(), buff.toString());
                return;
            }
            if (contextBuff.remaining() < length) {
                contextBuff.rewind();
                contextBuff.compact();
                break;
            }

            // 反序列化Message
            int msgID = contextBuff.getInt();
            byte[] bytes = new byte[length - 4];
            contextBuff.get(bytes);
            Message protoMessage = MsgAction.BufferNewMessage(msgID, bytes);
            if (protoMessage != null) {
                out.write(protoMessage);
            }

            if (contextBuff.remaining() == 0) {
                contextBuff.clear();
                break;
            }
            contextBuff.compact();
        }
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
