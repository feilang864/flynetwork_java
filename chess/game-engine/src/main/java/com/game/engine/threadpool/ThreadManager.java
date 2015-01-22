/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.threadpool;

import com.game.engine.struct.thread.DataRunnable;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 */
public class ThreadManager {

    private static final Logger logger = Logger.getLogger(ThreadManager.class);

    static ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance() {
        return instance;
    }
    BackThread backThread;
    HashMap<Long, RunnableThread> workHashMaps;
    private long noneThreadID;
    private long mapThreadID;
    private long chatThreadID;
    private long socialThreadID;

    public ThreadManager() {
        workHashMaps = new HashMap<>();
        backThread = new BackThread(5);
    }

    /**
     * 返回无名执行器
     *
     * @return
     */
    public long getNoneThreadID() {
        return noneThreadID;
    }

    /**
     * 返回地图线程执行器
     *
     * @return
     */
    public long getMapThreadID() {
        return mapThreadID;
    }

    /**
     * 返回聊天线程执行器
     *
     * @return
     */
    public long getChatThreadID() {
        return chatThreadID;
    }

    /**
     * 返回社交线程执行器
     *
     * @return
     */
    public long getSocialThreadID() {
        return socialThreadID;
    }

    public final Long getMapThread(ThreadGroup threadGroup, String workName) {
        RunnableThread wk = new RunnableThread(threadGroup, workName);
        workHashMaps.put(wk.getID(), wk);
        return wk.getID();
    }

    public final void addTask(long threadID, DataRunnable gameRunnable) {
        if (workHashMaps.containsKey(threadID)) {
            workHashMaps.get(threadID).addTask(gameRunnable);
        }
    }

    public final void addTask(DataRunnable gameRunnable) {
        workHashMaps.get(this.getNoneThreadID()).addTask(gameRunnable);
    }

    public final void addBackTask(DataRunnable gameRunnable) {
        backThread.addTask(gameRunnable);
    }
}
