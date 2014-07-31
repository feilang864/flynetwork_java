/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.main;

import com.flynetwork_game.engine.netty.NettyClient;

/**
 *
 * @author Administrator
 */
public class testClient {

    public static void main(String[] args) {
        new NettyClient().getBootstrap();
    }
}
