/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.thread;

import flynetwork.com.data.engine.manager.ThreadManager;
import flynetwork.com.data.engine.struct.thread.GameRunnable;
import flynetwork.com.data.engine.struct.thread.TimerEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_troy
 */
public class TimerThread extends GameRunnable {

    private static final long serialVersionUID = -8711653349963675546L;

    private static final Logger logger = Logger.getLogger(TimerThread.class);

    private static final ThreadGroup MAP_THREAD_GROUP = new ThreadGroup("全局定时器");
    /* 任务列表 */
    private final List<TimerEvent> taskQueue = Collections.synchronizedList(new LinkedList<TimerEvent>());

    public static TimerThread GetInstance(String Name) {
        TimerThread mapThread = new TimerThread(Name);
        return mapThread;
    }

    public static ThreadGroup getMAP_THREAD_GROUP() {
        return MAP_THREAD_GROUP;
    }

    private TimerThread(String Name) {
        super(Name);
        Long workerThread = ThreadManager.getInstance().getWorkerThread(MAP_THREAD_GROUP, this, Name);
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
        while (ThreadManager.getInstance().isRunning()) {
            List<TimerEvent> tempTimerEvents = null;
            synchronized (taskQueue) {
                while (ThreadManager.getInstance().isRunning() && taskQueue.isEmpty()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(200);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
                //队列不为空的情况下  取出队列定时器任务
                tempTimerEvents = new ArrayList<>(taskQueue);
            }

            if (ThreadManager.getInstance().isRunning() && !tempTimerEvents.isEmpty()) {
                for (TimerEvent timerEvent : tempTimerEvents) {
                    ThreadManager.getInstance().addTask(timerEvent.getID(), timerEvent);
                }
            }

            try {
                //定时器， 执行方式 间隔 10ms 执行一次 把需要处理的任务放到对应的处理线程
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
        logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
    }
}
