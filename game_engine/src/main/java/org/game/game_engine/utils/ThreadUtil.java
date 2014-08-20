/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.utils;

/**
 *
 * @author Administrator
 */
public class ThreadUtil {

    private static boolean running = true;

    public static boolean isRunning() {
        return running;
    }

    public static void setStopServer() {
        ThreadUtil.running = false;
    }

    public static int getThread(Runnable runnable) {
        return 0;
    }
}
