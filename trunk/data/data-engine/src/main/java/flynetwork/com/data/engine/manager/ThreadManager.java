/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.manager;

import flynetwork.com.data.engine.struct.thread.GameRunnable;
import flynetwork.com.data.engine.thread.BackThread;
import flynetwork.com.data.engine.thread.MapThread;
import flynetwork.com.data.engine.thread.RunnableThread;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class ThreadManager {

    private static final Logger logger = Logger.getLogger(ThreadManager.class);

    static ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance() {
        return instance;
    }
    BackThread backThread;
    HashMap<Long, RunnableThread> workHashMaps;
    private long mapThreadID;
    private long chatThreadID;
    private long socialThreadID;

    public ThreadManager() {
        workHashMaps = new HashMap<>();
        MapThread mapThread = new MapThread();
        workHashMaps.put(mapThread.getID(), mapThread);
        mapThreadID = mapThread.getID();
        chatThreadID = getMapThread(GlobeThreadGroup, "聊天线程执行器");
        socialThreadID = getMapThread(GlobeThreadGroup, "社交线程执行器");
//        backThread = new BackThread(5);
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

    private static boolean running = true;

    public static boolean isRunning() {
        return running;
    }

    public void StopServer() {
        running = false;
    }

    private static ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");

    public static ThreadGroup getGlobeThreadGroup() {
        return GlobeThreadGroup;
    }

    public final Long getMapThread(ThreadGroup threadGroup, String workName) {
        RunnableThread wk = new RunnableThread(threadGroup, workName);
        workHashMaps.put(wk.getID(), wk);
        return wk.getID();
    }

    public final void addTask(long threadID, GameRunnable gameRunnable) {
        if (workHashMaps.containsKey(threadID)) {
            workHashMaps.get(threadID).addTask(gameRunnable);
        }
    }

    public final void addBackTask(GameRunnable gameRunnable) {
        backThread.addTask(gameRunnable);
    }
}
