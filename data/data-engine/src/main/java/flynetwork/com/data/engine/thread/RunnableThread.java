/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.thread;

import flynetwork.com.data.engine.manager.GlobalManager;
import flynetwork.com.data.engine.struct.DataObject;
import flynetwork.com.data.engine.struct.thread.DataRunnable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class RunnableThread extends DataObject implements Runnable {

    private static final long serialVersionUID = 7479446431965332788L;

    private static final Logger logger = Logger.getLogger(RunnableThread.class);

    /* 任务列表 */
    protected final List<DataRunnable> taskQueue = Collections.synchronizedList(new LinkedList<DataRunnable>());

    boolean free = true;

    public RunnableThread(ThreadGroup group, String name) {
        super(name);
        Thread thread = new Thread(group, this, name);
        thread.start();
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

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
        logger.debug(this.getName() + " 接受任务 任务ID<" + runnable.getID() + ">");
    }

    @Override
    public void run() {
        while (GlobalManager.getInstance().isRunning()) {
            DataRunnable r = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && GlobalManager.getInstance().isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(500);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
                /* 取出任务执行 */
                if (GlobalManager.getInstance().isRunning()) {
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
                    e.printStackTrace();
                }
                r = null;
            }
        }
        logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
    }
}
