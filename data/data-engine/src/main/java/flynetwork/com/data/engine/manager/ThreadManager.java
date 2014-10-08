/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.manager;

import flynetwork.com.data.engine.struct.thread.GameRunnable;
import flynetwork.com.data.engine.thread.ServerThread;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class ThreadManager {

    private static final Logger logger = Logger.getLogger(ThreadManager.class);

    static ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance() {
        return instance;
    }

    HashMap<Long, ServerThread> workHashMaps;

    public long mapThread;
    public long dbThread;
    public long NoneThread;

    public ThreadManager() {
        workHashMaps = new HashMap<>();
        ThreadGroup tempGroup = new ThreadGroup(GlobeThreadGroup, "同步线程执行器");
        mapThread = getWorkerThread(tempGroup, "地图线程同步器");
        dbThread = getWorkerThread(tempGroup, "数据库线程同步器");
        NoneThread = getWorkerThread(tempGroup, "数据库线程同步器");
    }

    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void StopServer() {
        running = false;
    }

    public final ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");

    public Long getWorkerThread(ThreadGroup threadGroup, String workName) {
        ServerThread wk = new ServerThread(threadGroup, workName);
        workHashMaps.put(wk.getId(), wk);
        return wk.getId();
    }

    public Long getWorkerThread(ThreadGroup threadGroup, GameRunnable runnable, String workName) {
        ServerThread wk = new ServerThread(threadGroup, runnable, workName);
        workHashMaps.put(wk.getId(), wk);
        return wk.getId();
    }

    public void addTask(long threadID, GameRunnable gameRunnable) {
//        if (workHashMaps.containsKey(threadID)) {
//            workHashMaps.get(threadID).addTask(gameRunnable);
//        }
    }

    public static void addBackTask(GameRunnable gameRunnable) {
        //ThreadPoolUtil.addTask(gameRunnable);
    }
}
