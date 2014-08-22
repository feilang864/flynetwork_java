/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadmodel;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.game.game_engine.struct.BaseTask;
import org.game.game_engine.struct.GameObject;
import org.game.game_engine.utils.ThreadUtil;

/**
 * 地图线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class WorkThreadPool extends GameObject implements Runnable {

    final Logger logger = Logger.getLogger(WorkThreadPool.class);

    /* 任务列表 */
    private List<BaseTask> taskQueue;
    //自定义线程ID
    private long threadID = 1;

    WorkerThread workerThread = null;

    private WorkThreadPool() {
        this.threadID = 0;
        taskQueue = Collections.synchronizedList(new LinkedList<BaseTask>());
    }

    public static WorkThreadPool GetInstance(String mapName) {
        WorkThreadPool workThreadPool = new WorkThreadPool();
        workThreadPool.workerThread = new WorkerThread(workThreadPool);
        workThreadPool.setName(mapName);
        return workThreadPool;
    }

    @Override
    public String toString() {
        return "WorkThreadPool{" + super.toString() + ", taskQueue=" + taskQueue + ", threadID=" + threadID + ", workerThread=" + workerThread + '}';
    }

    /**
     * 循环执行任务 这也许是线程池的关键所在
     */
    @Override
    public void run() {
        while (ThreadUtil.isRunning()) {
            BaseTask r = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && ThreadUtil.isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(2000);
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
                    r.setBeginExceuteTime(new Date());
                    logger.debug("工人<" + this.threadID + "> 开始执行 任务<" + r.getTaskId() + ">(“" + r.info() + "”)");
                    if (r.getBeginExceuteTime().getTime() - r.getSubmitTime().getTime() > 1000L) {
                        logger.error("任务<" + r.getTaskId() + ">(“" + r.info() + "”)等待(“" + (r.getBeginExceuteTime().getTime() - r.getSubmitTime().getTime()) + "”ms) 被工人<" + this.threadID + ">执行");
                    }
                    /* 执行任务 */
                    r.run();
                    r.setFinishTime(new Date());
                    logger.debug("工人<" + this.threadID + "> 完成了任务 任务<" + r.getTaskId() + ">(“" + r.info() + "”)");
                    if (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime() > 1000L) {
                        logger.error("任务<" + r.getTaskId() + ">(“" + r.info() + "”)耗时(“" + (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime()) + "”ms) 被工人<" + this.threadID + ">完成");
                    }
                } catch (Exception e) {
                    logger.error(e);
                }
                r = null;
            }
        }
        logger.error("线程结束, 工人<" + this.threadID + ">退出");
    }

}
