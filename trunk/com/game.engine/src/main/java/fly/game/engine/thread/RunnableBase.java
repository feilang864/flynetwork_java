/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.thread;

import fly.game.engine.struct.ObjectBase;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class RunnableBase extends ObjectBase implements Runnable {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RunnableBase.class);
    private static final long serialVersionUID = 4183065253405130872L;

    /* 任务列表 */
    protected final List<TaskHandlerBase> taskQueue = Collections.synchronizedList(new LinkedList<TaskHandlerBase>());

    public RunnableBase() {
    }

    public RunnableBase(String Name) {
        super(Name);
    }

    public List<TaskHandlerBase> getTaskQueue() {
        return taskQueue;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param newTask
     */
    public void addTask(TaskHandlerBase newTask) {
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("提交任务 任务<" + newTask.getID() + ">: " + newTask.getName());
    }

    @Override
    public void run() {
        while (true) {
            TaskHandlerBase taskHandler = null;
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait(200);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    taskHandler = taskQueue.remove(0);
                }
            }
            if (taskHandler != null) {
                long startTime = System.currentTimeMillis();
                taskHandler.action();
                long endTime = System.currentTimeMillis();
                //if (endTime - startTime > 300) {
                logger.info("执行任务 任务<" + taskHandler.toString() + "> 耗时：" + (endTime - startTime));
                //}
            }
        }
    }

}
