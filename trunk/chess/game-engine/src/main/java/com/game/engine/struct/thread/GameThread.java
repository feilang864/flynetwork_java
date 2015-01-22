/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

/**
 *
 * @author Administrator
 */
public class GameThread extends Thread {

    private static int threadID = 0;
    private static final Object SYN_OBJECT = new Object();
    private int tid = 0;

    public GameThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        synchronized (SYN_OBJECT) {
            threadID++;
            tid = threadID;
        }
    }

    @Override
    public long getId() {
        return tid;
    }

}
