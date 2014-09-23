/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_login.gamemain;

import GLHandler.GLMessageHandler;
import com.game_engine.poolmessage.MessagePool;
import com.game_engine.utils.ThreadUtil;
import com.game_login.gametcpserver.GameTcpServer;
import protobuf.message.GLMessage;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        ThreadUtil.init(5);
        //DataManager instance = DataManager.getInstance();
        MessagePool.getInstance().registerHandlerMessage(100201, GLMessageHandler.class, GLMessage.class);
        GameTcpServer gameTcpServer = new GameTcpServer();
    }
}
