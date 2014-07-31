/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.tcpclient;

import com.flynetwork_game.engine.netty.NettyClient;

/**
 * logic to login server tcp
 *
 * @author Troy.Chen
 */
public class LLTcpClient {

    private static LLTcpClient tcpInstance;

    public static LLTcpClient getInstance() {
        if (tcpInstance == null) {
            tcpInstance = new LLTcpClient();
        }
        return tcpInstance;
    }

    private LLTcpClient() {
        NettyClient ns = new NettyClient(new LLTcpClientHandler());
        ns.setPort(9527);
        ns.start();
    }
}
