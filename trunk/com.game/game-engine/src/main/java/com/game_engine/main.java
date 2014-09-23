/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine;

import com.game_engine.struct.map.GameMapBase;
import com.game_engine.utils.MapUtil;
import com.game_engine.utils.ThreadUtil;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) throws InterruptedException {

        ThreadUtil.init(5);
        MapUtil.addMap(new GameMapBase(1, 3, "新手村") {
            private static final long serialVersionUID = 1L;
        });
        MapUtil.addMap(new GameMapBase(2, 2, "金银岛") {
            private static final long serialVersionUID = 1L;
        });
        MapUtil.addMap(new GameMapBase(4, 2, "神木村") {
            private static final long serialVersionUID = 1L;
        });
        MapUtil.addMap(new GameMapBase(5, 2, "地球防御本部") {
            private static final long serialVersionUID = 1L;
        });

//        PrintTask p = new PrintTask();
//        p.getGameAttribute().setValue("xxx", 10);
//        p.getGameAttribute().setValue("xxx", 11);
//        System.out.println(p.getGameAttribute().getStringValue("xxx"));
//        ServerThread threadPool = new ServerThread("Main");
//        MapThread mapThread = new MapThread("金银岛1线——");
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
