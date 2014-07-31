/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.tcpserver;

import com.flynetwork_game.engine.netty.NettyServer;

/**
 *
 * @author Administrator
 */
public class TcpServer {

    private static TcpServer tcpInstance;

    public static TcpServer getInstance() {
        if (tcpInstance == null) {
            tcpInstance = new TcpServer();
        }
        return tcpInstance;
    }

    public void start() {
        NettyServer ns = new NettyServer(new ActionMessageHandler());
        ns.start();
    }

    private TcpServer() {
    }

}
