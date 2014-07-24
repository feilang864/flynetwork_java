package com.flynetwork.game.routeserver.tcpbuffer;

import java.util.Arrays;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 */
public class BufferMarshalEncoder
        implements ProtocolEncoder {

    protected Logger log = LoggerFactory.getLogger(BufferMarshalEncoder.class);

    private static final int MAX_SIZE = 1048576;

    @Override
    public void dispose(IoSession session)
            throws Exception {
    }

    @Override
    public void encode(IoSession session, Object obj, ProtocolEncoderOutput out) throws Exception {

        byte[] msgData = new byte[MAX_SIZE];
        int msgDataLength = msgData.length;
        IoBuffer buf = IoBuffer.allocate(msgDataLength); // 4 len + 4 msgID   
        buf.put(msgData);
        buf.rewind();

        //ServerHelper.AddLoggerInfo("发送消息长度：" + buf.array().length + Arrays.toString(buf.array()));

        if (session.isConnected()) {
            out.write(buf);
            out.flush();
        }

    }
}
