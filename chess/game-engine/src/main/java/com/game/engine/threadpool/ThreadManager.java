package com.game.engine.threadpool;

import com.game.engine.struct.thread.BaseThread;
import com.game.engine.struct.thread.DataRunnable;
import com.game.engine.struct.thread.ThreadRunnable;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 */
public final class ThreadManager {

    private static final Logger log = Logger.getLogger(ThreadManager.class);

    static ThreadManager instance = new ThreadManager();

    static final HashMap<Long, BaseThread> workHashMaps = new HashMap<>(0);

    public static ThreadManager getInstance() {
        return instance;
    }

    public ThreadManager() {

    }

    public Long getThread(ThreadGroup threadGroup, ThreadRunnable target, String workName) {
        BaseThread wk = new BaseThread(threadGroup, target, workName);
        workHashMaps.put(wk.getId(), wk);
        return wk.getId();
    }

    public Long getThread(ThreadGroup threadGroup, String workName) {
        BaseThread thread = new BaseThread(threadGroup, new ThreadRunnable(), workName);
        thread.start();
        workHashMaps.put(thread.getId(), thread);
        return thread.getId();
    }

    public boolean delete(long threadID) {
        if (workHashMaps.containsKey(threadID)) {
            workHashMaps.get(threadID).delete();
            return true;
        }
        return false;
    }

    public void addTask(long threadID, DataRunnable gameRunnable) {
        if (workHashMaps.containsKey(threadID)) {
            workHashMaps.get(threadID).addTask(gameRunnable);
        }
    }

    /**
     *
     * @param gameRunnable
     */
    public void addBackTask(DataRunnable gameRunnable) {
        BackThread.getInstance().addTask(gameRunnable);
    }
}
