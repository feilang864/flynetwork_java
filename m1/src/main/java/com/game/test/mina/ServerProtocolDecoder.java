package com.game.test.mina;

import com.game.main.*;
import com.game.main.msgaction.MsgAction;
import com.game.myconst.ConstHelper;
import com.game.proto.LoginMessage;
import com.google.protobuf.Message;
import java.util.Arrays;
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
        byte[] bytes = new byte[8];
        Arrays.copyOf(bytes, 8);
        out.write(buff);
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
