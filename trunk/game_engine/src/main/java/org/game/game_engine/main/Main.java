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
       
        ThreadPool.setDebug(true);
        ThreadPool.setWorker_num(2);
        ThreadPool.getInstance().addTask(new PrintTask());      
        ThreadPool.getInstance().addTask(new PrintTask());        
        ThreadPool.getInstance().addTask(new PrintTask());
        Thread.sleep(10000);
        ThreadPool.getInstance().destroy();

    }
}
