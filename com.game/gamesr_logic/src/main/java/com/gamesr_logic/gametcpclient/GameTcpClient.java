/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesr_logic.gametcpclient;

import com.game_engine.poolnetty.NettyTcpClient;

/**
 *
 * @author fly_troy
 */
public class GameTcpClient {

    NettyTcpClient nettyTcpClient = new NettyTcpClient(9527);

    public GameTcpClient() {
        nettyTcpClient.Connect();
    }

}
