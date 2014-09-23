/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesr_logic.main;

import com.game.script.main.MainScript;
import com.game_engine.struct.map.GameMapBase;
import com.game_engine.struct.script.MyClassLoader;
import com.game_engine.utils.MapUtil;
import com.game_engine.utils.ThreadUtil;
import com.gamesr_logic.tcpclient.GameTcpClient;
import com.gamesr_logic.tcpserver.GameTcpServer;

/**
 *
 * @author fly_troy
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        MyClassLoader loader = new MyClassLoader("E:\\work\\java\\com.game\\gamesr_logic\\src\\main\\jscripts", "E:\\work\\java\\com.game\\gamesr_logic\\src\\main\\output");
//        MainScript ms = (MainScript) (loader.loadJava(null, "com.game.script.main.MainScript").newInstance());

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

//        ThreadUtil.init(5);
        GameTcpClient gameTcpClient = new GameTcpClient();
        GameTcpServer gameTcpServer = new GameTcpServer();
    }
}
