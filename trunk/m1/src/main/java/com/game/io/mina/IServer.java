package com.game.io.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Vicky
 */
public interface IServer {
    
    void doCommand(IoSession session, IoBuffer ioBuff);

    void sessionCreate(IoSession session);

    void sessionOpened(IoSession session);

    void sessionClosed(IoSession session);

    void exceptionCaught(IoSession session, Throwable throwable);

    void sessionIdle(IoSession session, IdleStatus idleStatus);
}
