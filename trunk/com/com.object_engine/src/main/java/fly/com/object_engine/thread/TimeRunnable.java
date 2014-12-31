/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.thread;

import fly.com.object_engine.struct.ObjectConfig;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
class TimeRunnable extends RunnableBase {

    private static final Logger log = Logger.getLogger(TimeRunnable.class);

    @Override
    public void addTask(TaskHandlerBase taskBase) {
        if (taskBase instanceof TimeTaskHandlerBase && ((TimeTaskHandlerBase) taskBase).isStartAction()) {
            this.action(taskBase);
        }
        super.addTask(taskBase);
    }

    private void action(TaskHandlerBase taskBase) {
        if (taskBase instanceof TimeTaskHandlerBase) {
            TimeTaskHandlerBase timerEvent = (TimeTaskHandlerBase) taskBase;
            int actionCount = timerEvent.getTempObjectAttribute().getintValue("actionCount");
            if ((timerEvent.getEndTime() > 0 && System.currentTimeMillis() > timerEvent.getEndTime()) || (timerEvent.getActionCount() > 0 && actionCount >= timerEvent.getActionCount())) {
                //任务过期
                log.error("定时器管理器 定时器任务执行过期 移除 " + timerEvent.toString());
                synchronized (taskQueue) {
                    taskQueue.remove(timerEvent);
                    return;
                }
            }
            long lastactiontime = timerEvent.getTempObjectAttribute().getlongValue("lastactiontime");
            if (lastactiontime != 0 && Math.abs(System.currentTimeMillis() - lastactiontime) < timerEvent.getIntervalTime()) {
                return;
            }
            ++actionCount;
            timerEvent.getTempObjectAttribute().put("actionCount", actionCount);
            timerEvent.getTempObjectAttribute().put("lastactiontime", System.currentTimeMillis());
            ThreadManager.getInstance().addTask(timerEvent);
        }
    }

    @Override
    public void run() {
        while (ObjectConfig.isRunning()) {
            List<TaskHandlerBase> tempTimerEvents = null;
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(200);
                    } catch (InterruptedException ie) {
                        log.error(ie);
                    }
                } else {
                    //队列不为空的情况下  取出队列定时器任务
                    tempTimerEvents = new ArrayList<>(taskQueue);
                }
            }
            if (tempTimerEvents != null && !tempTimerEvents.isEmpty()) {
                for (TaskHandlerBase taskBase : tempTimerEvents) {
                    this.action(taskBase);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
    }
}
