/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_login.gametcpserver;

import com.game_engine.poolnetty.NettyTcpServer;

/**
 *
 * @author Administrator
 */
public class GameTcpServer {

    NettyTcpServer nettyTcpServer = new NettyTcpServer(9527);

    public GameTcpServer() {
        nettyTcpServer.start();
    }

}