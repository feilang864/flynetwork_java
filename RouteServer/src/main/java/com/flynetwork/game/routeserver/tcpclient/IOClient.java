/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.routeserver.tcpclient;

import com.flynetwork.game.buffermanager.BufferMarshalFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 *
 * @author Vicky
 */
public class IOClient {

    protected Logger logger = Logger.getLogger(IOClient.class);
    ConnectFuture connectFuture;
    IoConnector connector;

    public IOClient() {
        connector = new NioSocketConnector();
        // 2.连接配置
        IoSessionConfig sessionConfig = connector.getSessionConfig();
        sessionConfig.setReaderIdleTime(300);
        sessionConfig.setReadBufferSize(1024 * 2);
        // 3创建过滤器
        DefaultIoFilterChainBuilder filterChain = connector.getFilterChain();
        IoFilter filter = new ProtocolCodecFilter(new BufferMarshalFactory());
        filterChain.addLast("codec", filter);
        // 5 创建处理器
        connector.setHandler(new IOHandler());
    }

    public void connect(String ipString, int portI) {
        if (connectFuture != null) {
            connectFuture.getSession().close(true);
            connectFuture.cancel();
            connectFuture = null;
        }
        connectFuture = connector.connect(new InetSocketAddress(ipString, portI));
    }

    public static void main(String[] args) throws IOException {
        IOClient ioc = new IOClient();
        ioc.connect("127.0.0.1", 9527);
        int ttI = System.in.read();
        ioc.connect("127.0.0.1", 9527);
    }
}
