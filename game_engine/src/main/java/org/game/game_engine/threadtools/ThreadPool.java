/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadtools;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 线程池 创建线程池，销毁线程池，添加新任务
 *
 * @author Troy.Chen
 */
public final class ThreadPool {

    private static Logger logger = Logger.getLogger(ThreadPool.class);
    private static Logger taskLogger = Logger.getLogger(ThreadPool.class);

    private static boolean debug = taskLogger.isDebugEnabled();
    /* 单例 */
    private static ThreadPool instance;
    /* 系统繁忙的任务数 默认 10万 */
    public static final int SYSTEM_BUSY_TASK_COUNT = 100000;
    /* 默认池中线程数 */
    public static int worker_num = 0;
    /* 已经处理的任务数 */
    private static int taskCounter = 0;
    /* 系统是否处于繁忙 */
    public static boolean systemIsBusy = false;
    /* 任务列表 */
    private final static List<Task> taskQueue = Collections.synchronizedList(new LinkedList<Task>());

    /* 池中的所有线程 */
    private PoolWorker[] workers;

    private ThreadPool() {
        if (ThreadPool.worker_num == 0) {
            ThreadPool.worker_num = 5;
        }
        workers = new PoolWorker[ThreadPool.worker_num];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new PoolWorker(i);
        }
    }

    public static synchronized ThreadPool getInstance() {
        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(Task newTask) {
        synchronized (taskQueue) {
            newTask.setTaskId(++taskCounter);
            newTask.setSubmitTime(new Date());
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.info("提交任务 任务<" + newTask.getTaskId() + ">: " + newTask.info());
    }

    /**
     * 批量增加新任务
     *
     * @param taskes
     */
    public void batchAddTask(Task[] taskes) {
        if (taskes == null || taskes.length == 0) {
            return;
        }
        for (int i = 0; i < taskes.length; i++) {
            if (taskes[i] == null) {
                continue;
            }
            addTask(taskes[i]);
        }
    }

    /**
     * 线程池信息
     *
     * @return
     */
    public String getInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n任务队列大小:").append(taskQueue.size());
        for (int i = 0; i < workers.length; i++) {
            sb.append("\n工人 ").append(i).append(" 在 ").append((workers[i].isWaiting()) ? "等待." : "工作.");
        }
        return sb.toString();
    }

    /**
     * 销毁线程池
     */
    public synchronized void destroy() {
        for (int i = 0; i < worker_num; i++) {
            workers[i].stopWorker();
            workers[i] = null;
        }
        taskQueue.clear();
    }

    /**
     * 池中工作线程
     *
     * @author Troy.Chen
     */
    private class PoolWorker extends Thread {

        //自定义线程ID
        private int index = -1;
        /* 该工作线程是否有效 */
        private boolean isRunning = true;
        /* 该工作线程是否可以执行新任务 */
        private boolean isWaiting = true;

        public PoolWorker(int index) {
            this.index = index;
            this.start();
        }

        public void stopWorker() {
            this.isRunning = false;
        }

        public boolean isWaiting() {
            return this.isWaiting;
        }

        /**
         * 循环执行任务 这也许是线程池的关键所在
         */
        public void run() {
            while (isRunning) {
                Task r = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && isRunning) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(20);
                        } catch (InterruptedException ie) {
                            logger.error(ie);
                        }
                    }
                    /* 取出任务执行 */
                    if (isRunning) {
                        r = (Task) taskQueue.remove(0);
                    }
                }
                if (r != null) {
                    isWaiting = false;
                    try {
                        r.setBeginExceuteTime(new Date());
                        logger.debug("工人<" + index + "> 开始执行 任务<" + r.getTaskId() + ">");
                        if (r.getBeginExceuteTime().getTime() - r.getSubmitTime().getTime() > 1000) {
                            logger.error("等待时间更长. " + r.info() + ",工人<" + index + ">,等待时间:" + (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime()));
                        }
                        /* 执行任务 */
                        r.run();
                        r.setFinishTime(new Date());
                        logger.debug("工人<" + index + "> 完成了任务 任务<" + r.getTaskId() + ">");
                        if (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime() > 1000) {
                            logger.error("执行了更长的时间. " + r.info() + ",工人<" + index + ">,执行时间:" + (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime()));
                        }
                    } catch (Exception e) {
                        logger.error(e);
                    }
                    isWaiting = true;
                    r = null;
                }
            }
            logger.debug("线程结束, 工人<" + index + ">退出");
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        ThreadPool.debug = debug;
    }

    public static int getWorker_num() {
        return worker_num;
    }

    public static void setWorker_num(int worker_num) {
        ThreadPool.worker_num = worker_num;
    }

    public static int getTaskCounter() {
        return taskCounter;
    }

    public static void setTaskCounter(int taskCounter) {
        ThreadPool.taskCounter = taskCounter;
    }

    public static boolean isSystemIsBusy() {
        return systemIsBusy;
    }

}
