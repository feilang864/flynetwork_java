/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.test.mina;

import com.game.myconst.ConstHelper;
import com.game.proto.UserVersionMessage;
import com.google.protobuf.Message;
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
        ConstHelper.AddLoggerInfo("收到消息");

        UserVersionMessage.ResUserVersionMessage.Builder newBuilder = UserVersionMessage.ResUserVersionMessage.newBuilder();
        UserVersionMessage.ReqUserVersionMessage req = (UserVersionMessage.ReqUserVersionMessage) message;
        newBuilder.setPstrIP(req.getVersion());
        UserVersionMessage.ResUserVersionMessage rs = newBuilder.build();
        session.write(rs);
        //messageSent(session, rs);
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
    public void exceptionCaught(IoSession session, Throwable cause) {
        ConstHelper.AddLoggerInfo("异常捕获" + cause.toString());

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        ConstHelper.AddLoggerInfo("消息发送");
        //session.write(message);
    }
}
