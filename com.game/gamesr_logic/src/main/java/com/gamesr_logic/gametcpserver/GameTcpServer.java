/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesr_logic.gametcpserver;

import com.game_engine.poolnetty.NettyTcpServer;

/**
 *
 * @author Administrator
 */
public class GameTcpServer {

    NettyTcpServer nettyTcpServer = new NettyTcpServer(9523);

    public GameTcpServer() {
        nettyTcpServer.start();
    }

}
