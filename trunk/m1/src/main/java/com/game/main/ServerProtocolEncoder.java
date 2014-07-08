package com.game.main;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
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
public class ServerProtocolEncoder
        implements ProtocolEncoder {

    protected Logger log = LoggerFactory.getLogger(ServerProtocolEncoder.class);

    private static final int MAX_SIZE = 1048576;

    @Override
    public void dispose(IoSession session)
            throws Exception {
    }

    @Override
    public void encode(IoSession session, Object obj, ProtocolEncoderOutput out)
            throws Exception {
        if (session.getScheduledWriteBytes() > MAX_SIZE) {
            SessionUtil.close(session, "需要发送的数据过长(%d)", session.getScheduledWriteBytes());
        }
        if (obj instanceof Message) {
            Message message = (Message) obj;
            // 获得消息ID
            Descriptors.EnumValueDescriptor field = (Descriptors.EnumValueDescriptor) message.getField(message.getDescriptorForType().findFieldByNumber(1));
            int msgID = field.getNumber(); // 100201
            // 获得二进制数据
            byte[] msgData = message.toByteArray();
            int msgDataLength = msgData.length;

            IoBuffer buf = IoBuffer.allocate(8 + msgDataLength); // 4 len + 4 msgID
            buf.putInt(msgDataLength + 4); // 不包含数据长度
            buf.putInt(msgID);
            buf.put(msgData);
            buf.rewind();
            if (session.isConnected()) {
                out.write(buf);
                out.flush();
            }
        } else {
            log.error("未知的数据类型");
        }
    }
}
