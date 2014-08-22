/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.threadpool;

import com.game_engine.struct.GameObject;
import com.game_engine.struct.GameRunnable;
import com.game_engine.utils.ThreadUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 工作线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class WorkerThread extends GameObject implements Runnable {

    Logger logger = Logger.getLogger(WorkerThread.class);

    /* 任务列表 */
    private final List<GameRunnable> taskQueue;

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(GameRunnable newTask) {
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("提交任务 任务<" + newTask.getID() + ">: " + newTask.getName());
    }
    //自定义线程ID
    private static Long threadID = 1L;

    private WorkerThread(String threadName) {
        this.setName(threadName);
        this.setID(++threadID);
        synchronized (threadID) {
            if (threadID + 1 >= Long.MAX_VALUE) {
                threadID = 0L;
            }
        }
        taskQueue = new ArrayList<>();
    }

    /**
     * 获取一个工作线程
     *
     * @param workName 工作名称
     * @return
     */
    public static WorkerThread GetInstance(String workName) {
        WorkerThread wt = new WorkerThread(workName);
        Thread thread = new Thread(wt);
        thread.setName(workName);
        thread.start();
        return wt;
    }

    @Override
    public void run() {
        while (ThreadUtil.isRunning()) {
            GameRunnable r = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && ThreadUtil.isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait();
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
            }
            /* 取出任务执行 */
            if (ThreadUtil.isRunning()) {
                r = taskQueue.remove(0);
            }
            if (r != null) {
                try {
                    /* 执行任务 */
                    r.run();
                    r.setFinishTimeL();
                    logger.info("工人<“" + this.getName() + "”> 完成了任务：" + r.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("工人<“" + this.getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                }
                r = null;
            }

        }
        logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
    }

    @Override
    public String toString() {
        return "{线程ID=" + this.getID() + '}';
    }

}
