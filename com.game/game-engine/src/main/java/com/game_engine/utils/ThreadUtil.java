/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.utils;

import com.game_engine.threadpool.WorkerThread;
import java.util.concurrent.ConcurrentHashMap;

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

    public static boolean isRunning() {
        return running;
    }

    public static void setStopServer() {
        ThreadUtil.running = false;
    }

    public static Long getWorkerThread(String workName) {
        WorkerThread wk = WorkerThread.GetInstance(workName);
        workHashMaps.put(wk.getID(), wk);
        return wk.getID();
    }

    public static ConcurrentHashMap<Long, WorkerThread> getWorkHashMaps() {
        return workHashMaps;
    }   
    
}
