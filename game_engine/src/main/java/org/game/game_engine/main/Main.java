/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import org.game.game_engine.struct.GameObject;
import org.game.game_engine.threadmodel.MapThread;
import org.game.game_engine.utils.MapUtil;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        MapUtil.addMap(new QMap(1L, "万恶之林"));
        MapUtil.addMap(new QMap(2L, "神木村"));
        MapUtil.addMap(new QMap(3L, "神木村副本1"));
        MapUtil.addMap(new QMap(4L, "神木村副本2"));
        MapUtil.addMap(new QMap(5L, "神木村副本3"));
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10; j++) {
                MapUtil.registerMessage(1L, 0, new PrintTask());
                MapUtil.registerMessage(2L, 0, new PrintTask());
                MapUtil.registerMessage(3L, 0, new PrintTask());
                MapUtil.registerMessage(4L, 0, new PrintTask());
                MapUtil.registerMessage(5L, 0, new PrintTask());

                MapUtil.registerMessage(1L, 1, new PrintTask());
                MapUtil.registerMessage(2L, 1, new PrintTask());
                MapUtil.registerMessage(3L, 1, new PrintTask());
                MapUtil.registerMessage(4L, 1, new PrintTask());
                MapUtil.registerMessage(5L, 1, new PrintTask());
            }
            Thread.sleep(10);
        }
    }
}
