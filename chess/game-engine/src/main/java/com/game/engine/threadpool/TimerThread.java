package com.game.engine.threadpool;

import com.game.engine.struct.GameGlobal;
import com.game.engine.struct.thread.BaseRunnable;
import com.game.engine.struct.thread.BaseThread;
import com.game.engine.struct.thread.TimerEventRunnable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 */
public class TimerThread {

    private static final Logger log = Logger.getLogger(TimerThread.class);

    private static final TimerThread instance = new TimerThread();

    public static TimerThread getInstance() {
        return instance;
    }

    /* 任务列表 */
    private final List<TimerEventRunnable> taskQueue = Collections.synchronizedList(new LinkedList<TimerEventRunnable>());
    private final TimerRunnable timerRunnable = new TimerRunnable();

    public TimerThread() {
        BaseThread thread = new BaseThread(GameGlobal.getInstance().getGlobeThreadGroup(), timerRunnable, "定时执行器");
        thread.start();
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTimerTask
     */
    public void addTimerTask(TimerEventRunnable newTimerTask) {
        log.debug("定时执行器 接受任务 " + newTimerTask.toString());
        synchronized (taskQueue) {
            taskQueue.add(newTimerTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
    }

    class TimerRunnable extends BaseRunnable {

        @Override
        public void run() {
            while (GameGlobal.getInstance().isRunning()) {
                List<TimerEventRunnable> tempTimerEvents = null;
                synchronized (taskQueue) {
                    while (GameGlobal.getInstance().isRunning() && taskQueue.isEmpty()) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(200);
                        } catch (InterruptedException ie) {
                            log.error(ie);
                        }
                    }
                    //队列不为空的情况下  取出队列定时器任务
                    tempTimerEvents = new ArrayList<>(taskQueue);
                }
                if (GameGlobal.getInstance().isRunning() && !tempTimerEvents.isEmpty()) {
                    for (TimerEventRunnable timerEvent : tempTimerEvents) {
                        int execCount = timerEvent.getTempAttribute().getintValue("Execcount");
                        long lastTime = timerEvent.getTempAttribute().getlongValue("LastExecTime");
                        if (System.currentTimeMillis() - lastTime >= timerEvent.getIntervalTime()) {

                            //ThreadManager.getInstance().addTask(timerEvent.getThreadID(), timerEvent);
                            execCount++;
                            if (timerEvent.getActionCount() == execCount) {
                                taskQueue.remove(timerEvent);
                            } else {
                                timerEvent.getTempAttribute().put("Execcount", execCount);
                                timerEvent.getTempAttribute().put("LastExecTime", System.currentTimeMillis());
                            }
                        }
                    }
                }
                try {
                    //定时器， 执行方式 间隔 10ms 执行一次 把需要处理的任务放到对应的处理线程
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
            }
            log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
        }
    }
}
