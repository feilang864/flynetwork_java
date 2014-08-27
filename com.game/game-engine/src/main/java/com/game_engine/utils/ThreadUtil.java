/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.utils;

import com.game_engine.poolthread.WorkerThread;
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

    static ConcurrentHashMap<Long, WorkerThread> workHashMaps = new ConcurrentHashMap<>();
    static final Logger logger = Logger.getLogger(ThreadUtil.class);

    public static boolean isRunning() {
        return running;
    }

    public static void init(int threadcountI) {
        logger.info("---------------初始化--线程池---开始----------------------");
        for (int i = 1; i <= threadcountI; i++) {
            WorkerThread wk = WorkerThread.GetInstance("thread-" + i);
            workHashMaps.put(wk.getID(), wk);
        }
        logger.info("---------------初始化--线程池---结束-----线程数量" + threadcountI + "------------");
        ThreadPoolUtil.Init(threadcountI);
    }

    public static void setStopServer() {
        ThreadUtil.running = false;
    }

    public synchronized static Long getBackWorkerThread(String workName) {
        for (Map.Entry<Long, WorkerThread> entry : workHashMaps.entrySet()) {
            Long long1 = entry.getKey();
            WorkerThread workerThread = entry.getValue();
            if (workerThread.isFree()) {
                workerThread.setFree(false);
                workerThread.setName(workName);
                return long1;
            }
        }
        return -1L;
    }

    public synchronized static Long getWorkerThread(String workName) {
        WorkerThread wk = WorkerThread.GetInstance(workName);
        workHashMaps.put(wk.getID(), wk);
        return wk.getID();
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
