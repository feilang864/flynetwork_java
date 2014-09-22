/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.utils;

import com.game_engine.struct.GameRunnable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;

/**
 * 线程利用器
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class ThreadUtil {

    private static boolean running = true;

    static ConcurrentHashMap<Long, ServerThread> workHashMaps = new ConcurrentHashMap<>();
    static final Logger logger = Logger.getLogger(ThreadUtil.class);

    public static boolean isRunning() {
        return running;
    }

    public static void init(int threadcountI) {        
        getWorkerThread(GlobeThreadGroup, "全局同步线程执行器");
        getWorkerThread(GlobeThreadGroup, "全局定时器管理执行器");
        getWorkerThread(GlobeThreadGroup, "全局数据库管理器");
        ThreadPoolUtil.Init(threadcountI);
    }

    public static void setStopServer() {
        ThreadUtil.running = false;
    }

    public synchronized static Long getBackWorkerThread(String workName) {
        for (Map.Entry<Long, ServerThread> entry : workHashMaps.entrySet()) {
            Long long1 = entry.getKey();
            ServerThread workerThread = entry.getValue();
            if (workerThread.isFree()) {
                workerThread.setFree(false);
                workerThread.setName(workName);
                return long1;
            }
        }
        return -1L;
    }
    public static final ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");
    public static final ThreadGroup MapThreadGroup = new ThreadGroup("地图线程");

    public synchronized static Long getWorkerThread(ThreadGroup threadGroup, String workName) {
        ServerThread wk = new ServerThread(threadGroup, workName);
        workHashMaps.put(wk.getId(), wk);
        return wk.getId();
    }

    public static void addTask(long threadID, GameRunnable gameRunnable) {
        if (workHashMaps.containsKey(threadID)) {
            workHashMaps.get(threadID).addTask(gameRunnable);
        }
    }

    public static void addBackTask(GameRunnable gameRunnable) {
        ThreadPoolUtil.addTask(gameRunnable);
    }
}
