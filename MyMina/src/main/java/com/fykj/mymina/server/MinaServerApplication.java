/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fykj.mymina.server;

import com.fykj.mymina.myconst.ConstHelper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author Administrator
 */
public class MinaServerApplication {

    IoAcceptor _acceptor;

    public MinaServerApplication() {
        //创建一个nio异步的socket监听服务器
        _acceptor = new NioSocketAcceptor();
        ///设置缓冲区大小，
        _acceptor.getSessionConfig().setReadBufferSize(1024 * 5);
        ///设置进入空闲状态时间，秒为单位
        _acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        ///添加实现类，客户端连接，断开，消息处理等
        _acceptor.setHandler(new MyIoHandler());
        ///添加过滤器，，，暂时忽虑，暂时不清楚使用
        _acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(), LineDelimiter.WINDOWS.getValue())));
       
    }

    /**
     * 启动 socket 监听
     *
     * @param port 监听端口号
     */
    public void Start(int port) {
        try {
            ///绑定一个监听端口号
            _acceptor.bind(new InetSocketAddress(port));
            ConstHelper.AddLoggerInfo("Nio异步的Socket监听服务器  " + port);
        } catch (Exception ex) {
            ConstHelper.AddLoggerInfo("Exception  " + ex.toString());
        }
    }

    /**
     * 释放Nio资源
     */
    public void Dispose() {
        _acceptor.dispose();
    }
}
