/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class BaseThread extends Thread {

    private static final Logger log = Logger.getLogger(BaseThread.class);
    private static int threadID = 0;
    private static final Object SYN_OBJECT = new Object();
    private int tid = 0;
    private BaseRunnable target;

    public BaseThread(ThreadGroup group, BaseRunnable target, String name) {
        super(group, target, name);
        synchronized (SYN_OBJECT) {
            threadID++;
            tid = threadID;
        }
        this.target = target;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param runnable
     */
    public void addTask(DataRunnable runnable) {
        if (this.target instanceof ThreadRunnable) {
            log.debug(this.getName() + " 接受任务 " + runnable.toString());
            ((ThreadRunnable) this.target).addTask(runnable);
        }
    }

    @Override
    public long getId() {
        return tid;
    }

    public void delete() {
        if (this.target instanceof ThreadRunnable) {
            ((ThreadRunnable) this.target).stop();
        }
    }

}
