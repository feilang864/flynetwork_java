/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fykj.mymina.server;

import com.fykj.mymina.myconst.ConstHelper;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Administrator
 */
public class MyIoHandler implements org.apache.mina.core.service.IoHandler {

    public MyIoHandler() {
        ConstHelper.AddLoggerInfo("创建业务处理类");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        ConstHelper.AddLoggerInfo("收到消息");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        ConstHelper.AddLoggerInfo("连接创建");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        ConstHelper.AddLoggerInfo("连接打开");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        ConstHelper.AddLoggerInfo("连接关闭");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        ConstHelper.AddLoggerInfo("空闲状态");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        ConstHelper.AddLoggerInfo("异常捕获");
    }

    
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        ConstHelper.AddLoggerInfo("消息发送");
    }
}
