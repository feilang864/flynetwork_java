package com.game.engine.struct.thread;

import com.game.engine.struct.GameGlobal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 */
public class ThreadRunnable extends BaseRunnable {

    private static final Logger log = Logger.getLogger(ThreadRunnable.class);
    /* 任务列表 */
    protected final List<DataRunnable> taskQueue = Collections.synchronizedList(new LinkedList<DataRunnable>());
    //false标识删除线程
    private boolean runing = true;

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param runnable
     */
    public void addTask(DataRunnable runnable) {
        synchronized (taskQueue) {
            taskQueue.add(runnable);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
    }

    /**
     *
     */
    public void stop() {
        runing = false;
    }

    @Override
    public void run() {
        while (runing && GameGlobal.getInstance().isRunning()) {
            DataRunnable r = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && runing && GameGlobal.getInstance().isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(500);
                    } catch (InterruptedException ie) {
                        log.error(ie);
                    }
                }
                /* 取出任务执行 */
                if (runing && GameGlobal.getInstance().isRunning()) {
                    r = taskQueue.remove(0);
                }
            }
            if (r != null) {
                try {
                    /* 执行任务 */
                    //r.setSubmitTimeL();
                    long submitTime = System.currentTimeMillis();
                    r.run();
                    long timeL = System.currentTimeMillis() - submitTime;
                    if (timeL <= 1L) {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 完成了任务：" + r.toString() + " 耗时：" + (timeL));
                    } else if (timeL <= 1000L) {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + (timeL));
                    } else if (timeL <= 4000L) {
                        log.info("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + (timeL));
                    } else {
                        log.error("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “考虑是否应该删除”任务脚本 耗时：" + (timeL));
                    }
                } catch (Exception e) {
                    log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                    e.printStackTrace();
                }
                r = null;
            }
        }
        log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
    }

}
