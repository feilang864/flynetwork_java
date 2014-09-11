/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine;

import com.game_engine.struct.map.MapThread;
import com.game_engine.utils.ServerThread;
import com.game_engine.utils.ThreadUtil;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) throws InterruptedException {
        PrintTask p = new PrintTask();
        p.getGameAttribute().setValue("xxx", 10);
        p.getGameAttribute().setValue("xxx", 11);
        System.out.println(p.getGameAttribute().getStringValue("xxx"));

        ServerThread threadPool = new ServerThread("Main");
        MapThread mapThread = new MapThread("金银岛1线——");
        //System.exit(0);
        //        MinaTcpServer minaTcpServer = new MinaTcpServer();
        //        if (!minaTcpServer.Start(9527)) {
        //            System.exit(0);
        //        }
        //
        //        MinaTcpClient clent = new MinaTcpClient();
        //        for (int i = 0; i < 1; i++) {
        //            System.err.println(i);
        //            clent.sendMessage("Hello World " + i);
        //        }
        //clent.getSocketConnector().dispose();
    }
}
