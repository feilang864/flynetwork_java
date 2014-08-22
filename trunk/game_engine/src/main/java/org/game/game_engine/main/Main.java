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
//        MapThread mapThread = MapThread.GetInstance("万恶之林");
//        MapThread mapThread1 = MapThread.GetInstance("神木村");

//        mapThread.addTask(0, new PrintTask());
//        mapThread1.addTask(0, new PrintTask());
//        mapThread.addTask(1, new PrintTask());
//        mapThread1.addTask(1, new PrintTask());
//        mapThread.addTask(0, new PrintTask());
//        mapThread1.addTask(0, new PrintTask());
//        mapThread.addTask(1, new PrintTask());
//        mapThread1.addTask(1, new PrintTask());
//        mapThread.addTask(0, new PrintTask());
//        mapThread1.addTask(0, new PrintTask());
//        mapThread.addTask(1, new PrintTask());
//        mapThread1.addTask(1, new PrintTask());
//        ThreadManager.getInstance().addTask(0, new PrintTask());
//        ThreadManager.getInstance().addTask(0, new PrintTask());
//        ThreadManager.getInstance().addTask(2, new PrintTask());
//        ThreadManager.getInstance().addTask(0, new PrintTask());
//        ThreadManager.getInstance().addTask(0, new PrintTask());
//        ThreadManager.getInstance().addTask(1, new PrintTask());
//
//        Thread.sleep(1000 * 20);
//        ThreadManager.getInstance().destroy();
    }
}
