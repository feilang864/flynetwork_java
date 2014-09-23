/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.thread.timer;

import com.game_engine.struct.GameObject;
import com.game_engine.struct.GameRunnable;
import com.game_engine.struct.timetask.TimerEvent;
import com.game_engine.thread.ServerThread;
import com.game_engine.utils.MapUtil;
import com.game_engine.utils.ThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_troy
 */
public class TimerThread extends GameObject implements Runnable {

    private static final long serialVersionUID = -8711653349963675546L;

    private static final Logger logger = Logger.getLogger(TimerThread.class);
    ServerThread serverThread;
    private static final ThreadGroup MAP_THREAD_GROUP = new ThreadGroup("全局定时器");
    /* 任务列表 */
    private final List<TimerEvent> taskQueue = Collections.synchronizedList(new LinkedList<TimerEvent>());

    public static TimerThread GetInstance(String Name) {
        TimerThread mapThread = new TimerThread(Name);
        mapThread.serverThread = new ServerThread(MAP_THREAD_GROUP, mapThread, Name);
        return mapThread;
    }

    public static ThreadGroup getMAP_THREAD_GROUP() {
        return MAP_THREAD_GROUP;
    }

    private TimerThread(String Name) {
        super(Name);
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(TimerEvent newTask) {
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("提交任务 任务<" + newTask.getID() + ">: " + newTask.getName());
    }

    @Override
    public void run() {
        while (ThreadUtil.isRunning()) {

            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && ThreadUtil.isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(200);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
            }
            //队列不为空的情况下  取出队列定时器任务
            List<TimerEvent> tempTimerEvents = null;
            synchronized (taskQueue) {
                tempTimerEvents = new ArrayList<>(taskQueue);
            }

            if (!tempTimerEvents.isEmpty() && ThreadUtil.isRunning()) {
                for (TimerEvent timerEvent : tempTimerEvents) {
                    MapUtil.addMessage(timerEvent.getMapId(), timerEvent.getLineId(), timerEvent);
                }
            }

            while (taskQueue.isEmpty() && ThreadUtil.isRunning()) {
                try {

                    /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                    taskQueue.wait(10);
                } catch (InterruptedException ie) {
                    logger.error(ie);
                }
            }

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
                    logger.error("工人<“" + this.getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                }
                r = null;
            }
        }
        logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
    }
}
