/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

import com.game.engine.struct.GameGlobal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class GameThread<T extends DataRunnable> extends Thread {

    private static final Logger log = Logger.getLogger(GameThread.class);
    private static int threadID = 0;
    private static final Object SYN_OBJECT = new Object();
    private int tid = 0;
    /* 任务列表 */
    protected final List<T> taskQueue = Collections.synchronizedList(new LinkedList<T>());

    boolean free = true;

    public GameThread() {
        this.setThreadID();
    }

    public GameThread(ThreadGroup group, String name) {
        super(group, name);
        this.setThreadID();
    }

    public GameThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setThreadID();
    }

    private void setThreadID() {
        synchronized (SYN_OBJECT) {
            threadID++;
            tid = threadID;
        }
    }

    @Override
    public long getId() {
        return tid;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param runnable
     */
    public void addTask(T runnable) {
        synchronized (taskQueue) {
            taskQueue.add(runnable);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        log.debug(this.getName() + " 接受任务 任务ID<" + runnable.getID() + ">");
    }

    @Override
    public void run() {
        while (GameGlobal.getInstance().isRunning()) {
            DataRunnable r = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && GameGlobal.getInstance().isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(500);
                    } catch (InterruptedException ie) {
                        log.error(ie);
                    }
                }
                /* 取出任务执行 */
                if (GameGlobal.getInstance().isRunning()) {
                    r = taskQueue.remove(0);
                }
            }
            if (r != null) {
                try {
                    /* 执行任务 */
                    //r.setSubmitTimeL();
                    long submitTime = System.currentTimeMillis();
                    r.run();
                    long timeL = System.currentTimeMillis() - r.getSubmitTime();
                    if (timeL <= 1L) {
                        log.info("工人<“" + this.getName() + "”> 完成了任务：" + r.toString() + " 耗时：" + (timeL));
                    } else if (timeL <= 1000L) {
                        log.info("工人<“" + this.getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + (timeL));
                    } else if (timeL <= 4000L) {
                        log.info("工人<“" + this.getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + (timeL));
                    } else {
                        log.error("工人<“" + this.getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “考虑是否应该删除”任务脚本 耗时：" + (timeL));
                    }
                } catch (Exception e) {
                    log.error("工人<“" + this.getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                    e.printStackTrace();
                }
                r = null;
            }
        }
        log.error("线程结束, 工人<“" + this.getName() + "”>退出");
    }

}
