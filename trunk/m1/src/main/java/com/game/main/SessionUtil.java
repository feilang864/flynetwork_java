package com.game.main;

import java.util.Arrays;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 */
public class SessionUtil {

    private static final Logger log = LoggerFactory.getLogger(SessionUtil.class);

    public static void close(IoSession session, String reason) {
        log.error(String.format("%s -->close [because] %s", session.toString(), reason));
        session.close(true);
    }

    public static void close(IoSession session, String fmt, Object... args) {
        String reason = String.format(fmt, args);
        log.error(String.format("%s -->close [because] %s", session.toString(), reason));
        session.close(true);
    }
}
