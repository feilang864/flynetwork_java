/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.poolmessage;

import flynetwork.com.data.engine.struct.thread.GameRunnable;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_ty
 */
public class MessageRunnable extends GameRunnable {

    private static final long serialVersionUID = 1707463603605340445L;
    private static final Logger logger = Logger.getLogger(MessageRunnable.class);

    ActionMessageHandler msgHandler;
    long threadID;

    public MessageRunnable(long threadid, ActionMessageHandler handler) {
        super("");
        threadID = threadid;
        msgHandler = handler;
    }

    public ActionMessageHandler getMsgHandler() {
        return msgHandler;
    }

    public long getThreadID() {
        return threadID;
    }

    @Override
    public void run() {
        msgHandler.action();
    }
}
