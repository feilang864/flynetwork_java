/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sz.network.threadpool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
class BackThread {

    private static final Logger log = Logger.getLogger(BackThread.class);

    private final ThreadGroup threadGroup = new ThreadGroup(ThreadManager.getGlobeThreadGroup(), "后台执行器");

    /* 任务列表 */
    private final List<TaskModel> taskQueue = Collections.synchronizedList(new LinkedList<TaskModel>());
    private final BackThreadRunnable backThreadRunnable = new BackThreadRunnable();

    public BackThread() {
        int threadcountI = 10;
        for (int i = 1; i <= threadcountI; i++) {
            Thread thread = new Thread(threadGroup, backThreadRunnable, "后台线程-" + i);
            thread.start();
        }
        log.info("---初始化后台线程池--线程数量:" + threadcountI + "------------");
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(TaskModel newTask) {
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
    }

    final class BackThreadRunnable implements Runnable {

        /**
         * 循环执行任务
         */
        @Override
        public void run() {
            while (ThreadManager.getInstance().isRunning()) {
                TaskModel r = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && ThreadManager.getInstance().isRunning()) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(500);
                        } catch (InterruptedException ie) {
                            log.error(ie);
                        }
                    }
                    /* 取出任务执行 */
                    if (ThreadManager.getInstance().isRunning()) {
                        r = taskQueue.remove(0);
                    }
                }
                if (r != null) {
                    /* 执行任务 */
                    //r.setSubmitTimeL();
                    long submitTime = System.currentTimeMillis();
                    try {
                        r.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                    }
                    long timeL1 = System.currentTimeMillis() - submitTime;
                    long timeL2 = System.currentTimeMillis() - r.getSubmitTime();
                    if (timeL1 <= 100L) {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 完成了任务：" + r.toString() + " 执行耗时：" + timeL1 + " 提交耗时：" + timeL2);
                    } else if (timeL1 <= 1000L) {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                    } else if (timeL1 <= 4000L) {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                    } else {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “考虑是否应该删除”任务脚本 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                    }
                    r = null;
                }
            }
            log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
        }
    }
}
