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
public class TimeTaskThread {

    private static final Logger logger = Logger.getLogger(TimeTaskThread.class);
    /* 任务列表 */
    private final List<TimeTaskHandlerBase> taskQueue = Collections.synchronizedList(new LinkedList<TimeTaskHandlerBase>());

    public TimeTaskThread() {
        ThreadGroup threadGroup = new ThreadGroup("全局定时器执行线程");
        Thread thread = new Thread(threadGroup, new taskrun(), "全局定时器执行线程");
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

    class taskrun implements Runnable {

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
                        ThreadManager.getInstance().addTask(timerEvent.getActionThreadId(), timerEvent);
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
