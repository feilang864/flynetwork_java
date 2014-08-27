/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolthread;

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
    boolean free = true;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

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
    private Thread thread;

    public void setThreadName(String threadName) {
        thread.setName(threadName);
    }

    private WorkerThread(String threadName) {
        super(++threadID, threadName);
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
        wt.thread = new Thread(wt);
        wt.thread.setName(workName);
        wt.thread.start();
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
                    r.setSubmitTimeL();
                    r.run();
                    r.setFinishTimeL();
                    long timeL = r.getFinishTimeL() - r.getSubmitTimeL();
                    if (timeL <= 100L) {
                        logger.info("工人<“" + this.getName() + "”> 完成了任务：" + r.toString() + " 耗时：" + (timeL));
                    } else if (timeL <= 1000L) {
                        logger.error("工人<“" + this.getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + (timeL));
                    } else if (timeL > 2000L) {
                        logger.error("工人<“" + this.getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + (timeL));
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

    @Override
    public String toString() {
        return "{线程ID=" + this.getID() + '}';
    }

}
