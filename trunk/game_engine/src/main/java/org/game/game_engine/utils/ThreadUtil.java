/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.utils;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
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
