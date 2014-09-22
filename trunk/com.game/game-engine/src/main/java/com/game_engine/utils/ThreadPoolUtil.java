/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.utils;

import com.game_engine.struct.GameObject;
import com.game_engine.struct.GameRunnable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 线程池，后台执行
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
class ThreadPoolUtil {

    private static final Logger logger = Logger.getLogger(ThreadPoolUtil.class);

    /* 任务列表 */
    private final static List<GameRunnable> taskQueue = Collections.synchronizedList(new LinkedList<GameRunnable>());

    private ThreadPoolUtil() {
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public static void addTask(GameRunnable newTask) {
        if (taskQueue == null) {
            logger.error("尚未初始化后台线程池");
            return;
        }
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("提交任务 任务<" + newTask.getID() + ">: " + newTask.getName());
    }

    public static void Init(int threadcountI) {
        ThreadGroup threadGroup = new ThreadGroup(ThreadUtil.GlobeThreadGroup, "后台线程");
        for (int i = 1; i <= threadcountI; i++) {
            Thread thread = new Thread(threadGroup, new BackThreadRunnable("后台线程-" + i), "后台线程-" + i);
            thread.start();
        }
        logger.info("---------------初始化后台线程池-----结束-----线程数量" + threadcountI + "------------");
    }

    static class BackThreadRunnable extends GameObject implements Runnable {

        public BackThreadRunnable(String Name) {
            super(Name);
        }

        /**
         * 循环执行任务 这也许是线程池的关键所在
         */
        @Override
        public void run() {
            while (ThreadUtil.isRunning()) {
                GameRunnable r = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && ThreadUtil.isRunning()) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(500);
                        } catch (InterruptedException ie) {
                            logger.error(ie);
                        }
                    }
                    /* 取出任务执行 */
                    if (ThreadUtil.isRunning()) {
                        r = taskQueue.remove(0);
                    }
                }

                if (r != null) {
                    try {
                        /* 执行任务 */
                        //r.setSubmitTimeL();
                        r.run();
                        r.setFinishTimeL();
                        long timeL = r.getFinishTimeL() - r.getSubmitTimeL();
                        if (timeL <= 100L) {
                            logger.debug("工人<“" + this.getName() + "”> 完成了任务：" + r.toString() + " 耗时：" + (timeL));
                        } else if (timeL <= 1000L) {
                            logger.debug("工人<“" + this.getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + (timeL));
                        } else if (timeL <= 4000L) {
                            logger.debug("工人<“" + this.getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + (timeL));
                        } else {
                            logger.error("工人<“" + this.getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “考虑是否应该删除”任务脚本 耗时：" + (timeL));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("工人<“" + this.getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                    }
                    r = null;
                }
            }
            logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
        }
    }
}
