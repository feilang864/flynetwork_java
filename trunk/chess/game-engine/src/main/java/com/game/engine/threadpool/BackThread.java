package com.game.engine.threadpool;

import com.game.engine.struct.GameGlobal;
import com.game.engine.struct.thread.BaseRunnable;
import com.game.engine.struct.thread.BaseThread;
import com.game.engine.struct.thread.DataRunnable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 线程池，后台执行
 */
public class BackThread {

    private static final Logger log = Logger.getLogger(BackThread.class);
    private static final BackThread instance = new BackThread();

    private static final ThreadGroup threadGroup = new ThreadGroup(GameGlobal.getInstance().getGlobeThreadGroup(), "后台执行器");

    public static BackThread getInstance() {
        return instance;
    }
    /* 任务列表 */
    private final List<DataRunnable> taskQueue = Collections.synchronizedList(new LinkedList<DataRunnable>());
    private final BackThreadRunnable backThreadRunnable = new BackThreadRunnable();

    public BackThread() {
        int threadcountI = 10;
        for (int i = 1; i <= threadcountI; i++) {
            BaseThread thread = new BaseThread(threadGroup, backThreadRunnable, "后台线程-" + i);
            thread.start();
        }
        log.info("---初始化后台线程池--线程数量:" + threadcountI + "------------");
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(DataRunnable newTask) {
        log.debug("后台线程 接受任务 " + newTask.toString());
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
    }

    final class BackThreadRunnable extends BaseRunnable {

        /**
         * 循环执行任务 这也许是线程池的关键所在
         */
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
                        long timeL1 = System.currentTimeMillis() - submitTime;
                        long timeL2 = System.currentTimeMillis() - r.getSubmitTime();
                        if (timeL1 <= 100L) {
                            log.debug("工人<“" + Thread.currentThread().getName() + "”> 完成了任务：" + r.toString() + " 执行耗时：" + timeL1 + " 提交耗时：" + timeL2);
                        } else if (timeL1 <= 1000L) {
                            log.debug("工人<“" + Thread.currentThread().getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                        } else if (timeL1 <= 4000L) {
                            log.debug("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                        } else {
                            log.error("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “考虑是否应该删除”任务脚本 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                    }
                    r = null;
                }
            }
            log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
        }
    }
}
