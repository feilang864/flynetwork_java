/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.routeserver.tcpclient;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 客户端处理
 * @author Administrator
 */
public class IOHandler implements IoHandler {

    protected Logger logger = Logger.getLogger(IOHandler.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.debug("创建一个会话链接（未连接）");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.debug("服务器与客户端会建立连接");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.debug("服务器与客户端会话链接已经关闭");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.debug("客户端端进入空闲状态");
        //session.close(false);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.debug("Error:客户端捕获到异常" + cause);
        session.close(true);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.debug("接收到服务器端消息:" + message);
    }

    /**
     * 注意这里是消息发送后回调，非发送消息！！！
     */
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        // 发送返回消息后就断开与客户端的链接，这就类似HTTP请求一样的短链接模式
        // session.close(true)
    }
}
