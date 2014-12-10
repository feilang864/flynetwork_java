/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.thread;

import fly.com.object_engine.struct.ObjectConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
class TimeTaskThread implements Runnable {

    private static final Logger logger = Logger.getLogger(TimeTaskThread.class);
    /* 任务列表 */
    private final List<TimeTaskHandlerBase> taskQueue = Collections.synchronizedList(new LinkedList<TimeTaskHandlerBase>());

    public TimeTaskThread() {
        Thread thread = new Thread(ObjectConfig.getThreadGroup(), this, "全局定时器执行线程");
        thread.start();
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(TimeTaskHandlerBase newTask) {
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("提交任务 任务<" + newTask.getID() + ">: " + newTask.getName());
    }

    @Override
    public void run() {
        while (ObjectConfig.isRunning()) {
            List<TimeTaskHandlerBase> tempTimerEvents = null;
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(200);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                } else {
                    //队列不为空的情况下  取出队列定时器任务
                    tempTimerEvents = new ArrayList<>(taskQueue);
                }
            }
            if (tempTimerEvents != null && !tempTimerEvents.isEmpty()) {
                for (TimeTaskHandlerBase timerEvent : tempTimerEvents) {
                    int actionCount = timerEvent.getTempObjectAttribute().getIntValue("actionCount");
                    if ((timerEvent.getEndTime() > 0 && System.currentTimeMillis() > timerEvent.getEndTime()) || (timerEvent.getActionCount() > 0 && actionCount > timerEvent.getActionCount())) {
                        //任务过期
                        synchronized (taskQueue) {
                            taskQueue.remove(timerEvent);
                            continue;
                        }
                    }
                    long lastactiontime = timerEvent.getTempObjectAttribute().getLongValue("lastactiontime");
                    if (lastactiontime != 0 && Math.abs(System.currentTimeMillis() - lastactiontime) < timerEvent.getIntervalTime()) {
                        continue;
                    }
                    timerEvent.getTempObjectAttribute().setValue("actionCount", ++actionCount);
                    timerEvent.getTempObjectAttribute().setValue("lastactiontime", System.currentTimeMillis());
                    ThreadManager.getInstance().addTask(timerEvent);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
    }
}
