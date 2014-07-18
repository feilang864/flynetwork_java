/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flynetwork.gameserver.tcpserver;

import com.flynetwork.mygameserver.ServerHelper;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Administrator
 */
public class MinaIoHandler implements org.apache.mina.core.service.IoHandler {

    public MinaIoHandler() {
        ServerHelper.AddLoggerInfo("创建业务处理类");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        ServerHelper.AddLoggerInfo("收到消息");
//        UserVersionMessage.ReqUserVersionMessage req = (UserVersionMessage.ReqUserVersionMessage) message;
//        
//        UserVersionMessage.ResUserVersionMessage.Builder newBuilder = UserVersionMessage.ResUserVersionMessage.newBuilder();
//        newBuilder.setPstrIP(req.getVersion());
//        UserVersionMessage.ResUserVersionMessage rs = newBuilder.build();
//        session.write(rs);
//        //messageSent(session, rs);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        ServerHelper.AddLoggerInfo("连接创建");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        ServerHelper.AddLoggerInfo("连接打开");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        ServerHelper.AddLoggerInfo("连接关闭");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        ServerHelper.AddLoggerInfo("空闲状态");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        ServerHelper.AddLoggerInfo("异常捕获" + cause.toString());

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        ServerHelper.AddLoggerInfo("消息发送");
        //session.write(message);
    }
}