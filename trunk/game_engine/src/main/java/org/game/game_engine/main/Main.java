/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import org.game.game_engine.threadmodel.ThreadManager;
import org.game.game_engine.utils.MapThread;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        MapThread mapThread = MapThread.GetInstance("万恶之林");
        MapThread mapThread1 = MapThread.GetInstance("神木村");

        mapThread.addTask(0, new PrintTask());
        mapThread1.addTask(0, new PrintTask());
        mapThread.addTask(1, new PrintTask());
        mapThread1.addTask(1, new PrintTask());
        mapThread.addTask(0, new PrintTask());
        mapThread1.addTask(0, new PrintTask());
        mapThread.addTask(1, new PrintTask());
        mapThread1.addTask(1, new PrintTask());
        mapThread.addTask(0, new PrintTask());
        mapThread1.addTask(0, new PrintTask());
        mapThread.addTask(1, new PrintTask());
        mapThread1.addTask(1, new PrintTask());
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
