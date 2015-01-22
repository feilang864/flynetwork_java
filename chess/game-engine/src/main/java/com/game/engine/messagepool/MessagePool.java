/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.messagepool;

import org.apache.log4j.Logger;

/**
 *
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
