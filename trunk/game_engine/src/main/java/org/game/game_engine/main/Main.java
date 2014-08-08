/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import org.game.game_engine.threadtools.ThreadPool;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        PrintTask pt = new PrintTask();
        ThreadPool.setDebug(true);
        ThreadPool.setWorker_num(2);
        ThreadPool.getInstance().addTask(new PrintTask());      
        ThreadPool.getInstance().addTask(new PrintTask());        
        ThreadPool.getInstance().addTask(new PrintTask());
        Thread.sleep(5000);
        ThreadPool.getInstance().destroy();

    }
}
