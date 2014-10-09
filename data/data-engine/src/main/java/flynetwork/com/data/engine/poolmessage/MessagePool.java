/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.poolmessage;

import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MessagePool {

    private static final MessagePool instance = new MessagePool();

    public static MessagePool getInstance() {
        return instance;
    }
    private static final Logger logger = Logger.getLogger(MessagePool.class);

    ThreadMessage messageThread;

    public MessagePool() {
        messageThread = new ThreadMessage("Netty消息处理器");
    }

    public void registerMessage(MessageBean messageBean) {
        messageThread.addTask(messageBean);
    }
}
