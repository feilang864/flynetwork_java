/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.threadpool;

import com.game.engine.struct.thread.DataRunnable;
import com.game.engine.struct.thread.GameThread;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 */
public class ThreadManager {

    private static final Logger logger = Logger.getLogger(ThreadManager.class);

    static ThreadManager instance = new ThreadManager();

    static final HashMap<Long, GameThread> workHashMaps = new HashMap<>(0);

    public static ThreadManager getInstance() {
        return instance;
    }

    public ThreadManager() {

    }

    public final Long getThread(ThreadGroup threadGroup, String workName) {
        GameThread wk = new GameThread(threadGroup, workName);
        workHashMaps.put(wk.getId(), wk);
        return wk.getId();
    }

    public final Long addThread(GameThread thread) {
        workHashMaps.put(thread.getId(), thread);
        return thread.getId();
    }

    public final void addTask(long threadID, DataRunnable gameRunnable) {
        if (workHashMaps.containsKey(threadID)) {
            workHashMaps.get(threadID).addTask(gameRunnable);
        }
    }

    /**
     *
     * @param gameRunnable
     */
    public final void addBackTask(DataRunnable gameRunnable) {
        BackThread.getInstance().addTask(gameRunnable);
    }
}
