/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadmodel;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 线程模型管理器
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 *
 */
public class ThreadManager {

    public Logger logger = Logger.getLogger(ThreadManager.class);
    //public HashMap<Integer, List<BaseTask>> taskQueue = new HashMap<>();

    private static ThreadManager instance;

    /* 系统繁忙的任务数 默认 10万 */
    public static final int SYSTEM_BUSY_TASK_COUNT = 100000;
    /* 默认线程池中的线程数 */
    private static int worker_num = 0;
    /* 已经处理的任务数 */
    private static int taskCounter = 0;
    /* 系统是否处于繁忙 */
    private static boolean systemIsBusy = false;

    /* 池中的所有线程 */
    private ThreadToolsWorker[] workers;

    public static ThreadManager getInstance() {
        if (instance == null) {
            synchronized (ThreadManager.class) {
                if (instance == null) {
                    instance = new ThreadManager();
                }
            }
        }
        return instance;
    }


    /* 任务列表 */
    private ThreadManager() {
        if (worker_num == 0) {
            worker_num = 5;
        }
        workers = new ThreadToolsWorker[worker_num];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new ThreadToolsWorker(i);
        }
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param threadInteger
     * @param newTask
     */
    public synchronized void addTask(Integer threadInteger, BaseTask newTask) {
        if (newTask != null) {
            newTask.setTaskId(++taskCounter);
            newTask.setSubmitTime(new Date());
            workers[threadInteger].addTask(newTask);
            logger.debug("提交任务 任务<" + newTask.getTaskId() + ">: " + newTask.info());
        }
    }

    /**
     * 批量增加新任务
     *
     * @param threadInteger
     * @param taskes
     */
    public void batchAddTask(Integer threadInteger, BaseTask[] taskes) {
        if (taskes == null || taskes.length == 0) {
            return;
        }
        for (int i = 0; i < taskes.length; i++) {
            addTask(threadInteger, taskes[i]);
        }
    }

    /**
     * 添加释放状态，提示程序退出，表示任务必须结算了
     */
    public synchronized void destroy() {
        for (int i = 0; i < worker_num; i++) {
            workers[i].stopWorker();
            workers[i] = null;
        }
    }

    public static int getWorker_num() {
        return worker_num;
    }

    public static void setWorker_num(int worker_num) {
        ThreadManager.worker_num = worker_num;
    }

    public static int getTaskCounter() {
        return taskCounter;
    }

    public static void setTaskCounter(int taskCounter) {
        ThreadManager.taskCounter = taskCounter;
    }
    
    
    
}
