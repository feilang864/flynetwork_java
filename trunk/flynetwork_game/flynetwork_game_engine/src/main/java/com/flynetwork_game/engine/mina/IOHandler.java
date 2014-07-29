/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.mina;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Administrator
 */
public class IOHandler implements org.apache.mina.core.service.IoHandler {

    protected Logger logger = Logger.getLogger(IOHandler.class);

    public IOHandler() {
        logger.info("创建业务处理类");

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.debug("收到消息");

    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("连接创建");

    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("连接打开");

    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("连接关闭");

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("空闲状态");

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        logger.error("异常捕获" + cause.toString());

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("消息发送");
        //session.write(message);
    }
}
