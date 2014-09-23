/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_login.gamemain;

import com.game_engine.poolmessage.MessagePool;
import com.game_engine.utils.ThreadUtil;
import com.game_login.gametcpserver.GameTcpServer;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        ThreadUtil.init(5);
        //DataManager instance = DataManager.getInstance();
        MessagePool.getInstance().registerHandlerMessage(100201, null, null);
        GameTcpServer gameTcpServer = new GameTcpServer();
    }
}
