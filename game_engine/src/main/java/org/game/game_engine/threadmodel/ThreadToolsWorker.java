/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadmodel;

import org.game.game_engine.struct.BaseTask;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 线程辅助
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 *
 */
class ThreadToolsWorker extends Thread {

    /* 任务列表 */
    private List<BaseTask> taskQueue;

    final Logger logger = Logger.getLogger(ThreadToolsWorker.class);
    //自定义线程ID
    private Integer threadInteger = -1;
    /* 该工作线程是否有效 */
    private boolean isRunning = true;
    /* 该工作线程是否可以执行新任务 */
    private boolean isWaiting = true;

    public ThreadToolsWorker(Integer threadInteger) {
        this.threadInteger = threadInteger;
        taskQueue = Collections.synchronizedList(new LinkedList<BaseTask>());
        this.start();
    }

    public void stopWorker() {
        this.isRunning = false;
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(BaseTask newTask) {
        synchronized (taskQueue) {            
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("提交任务 任务<" + newTask.getTaskId() + ">: " + newTask.info());
    }
    
    /**
     * 循环执行任务 这也许是线程池的关键所在
     */
    @Override
    public void run() {
        while (isRunning) {
            BaseTask r = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && isRunning) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(2000);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
            }
            /* 取出任务执行 */
            if (isRunning) {
                r = taskQueue.remove(0);
            }
            if (r != null) {
                isWaiting = false;
                try {
                    r.setBeginExceuteTime(new Date());
                    logger.debug("工人<" + this.threadInteger + "> 开始执行 任务<" + r.getTaskId() + ">(“" + r.info() + "”)");
                    if (r.getBeginExceuteTime().getTime() - r.getSubmitTime().getTime() > 1000L) {
                        logger.error("任务<" + r.getTaskId() + ">(“" + r.info() + "”)等待(“" + (r.getBeginExceuteTime().getTime() - r.getSubmitTime().getTime()) + "”ms) 被工人<" + this.threadInteger + ">执行");
                    }
                    /* 执行任务 */
                    r.run();
                    r.setFinishTime(new Date());
                    logger.debug("工人<" + this.threadInteger + "> 完成了任务 任务<" + r.getTaskId() + ">(“" + r.info() + "”)");
                    if (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime() > 1000L) {
                        logger.error("任务<" + r.getTaskId() + ">(“" + r.info() + "”)耗时(“" + (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime()) + "”ms) 被工人<" + this.threadInteger + ">完成");
                    }
                } catch (Exception e) {
                    logger.error(e);
                }
                isWaiting = true;
                r = null;
            }
        }
        logger.error("线程结束, 工人<" + this.threadInteger + ">退出");
    }
}
