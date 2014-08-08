/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import org.game.game_engine.threadtools.ThreadManager;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadManager.getInstance().addShortTimeTask(new PrintTask());
        ThreadManager.getInstance().addShortTimeTask(new PrintTask());
        ThreadManager.getInstance().addShortTimeTask(new PrintTask());

        Thread.sleep(10000);

        ThreadManager.getInstance().destroy();
    }
}
