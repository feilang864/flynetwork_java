/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.logic;

import com.game.engine.nettypool.NettyTcpClient;
import com.game.engine.nettypool.NettyTcpServer;
import com.game.engine.threadpool.ThreadManager;
import com.game.logic.tcpmessage.TcpHandler;

/**
 *
 * @author fly_ty
 */
public class Test {

    public static void main(String[] args) {
        ThreadManager.getInstance();
        TcpHandler tcpHandler = new TcpHandler();
        NettyTcpServer tcpServer = new NettyTcpServer(9527, tcpHandler);
        tcpServer.start();
        NettyTcpClient tcpClient = new NettyTcpClient("127.0.0.1", 9527, true, tcpHandler);
        tcpClient.Connect();
    }
}
