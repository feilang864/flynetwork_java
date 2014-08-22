/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine;

import com.game_engine.utils.MapUtil;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) throws InterruptedException {
        MapUtil.addMap(new TestMap(1L, "万恶之林"));
        MapUtil.addMap(new TestMap(2L, "神木村"));
        MapUtil.addMap(new TestMap(3L, "神木村副本1"));
        MapUtil.addMap(new TestMap(4L, "神木村副本2"));
        MapUtil.addMap(new TestMap(5L, "神木村副本3"));
        for (int i = 0; i < 10000; i++) {
          
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
                
                MapUtil.registerMessage(1L, 2, new PrintTask());
                MapUtil.registerMessage(2L, 2, new PrintTask());
                MapUtil.registerMessage(3L, 2, new PrintTask());
                MapUtil.registerMessage(4L, 2, new PrintTask());
                MapUtil.registerMessage(5L, 2, new PrintTask());
         
            Thread.sleep(5);
        }
    }
}
