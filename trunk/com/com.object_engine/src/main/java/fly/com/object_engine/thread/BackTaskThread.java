/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class BackTaskThread {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TaskThread.class);
    /* 任务列表 */
    private final List<TaskHandlerBase> taskQueue = Collections.synchronizedList(new LinkedList<TaskHandlerBase>());

    public BackTaskThread(String threadName, int count) {
        ThreadGroup group = new ThreadGroup(threadName);
        for (int i = 0; i < count; i++) {
            ThreadGroup threadGroup = new ThreadGroup(group, threadName + i);
            Thread thread = new Thread(threadGroup, new ThreadRun(), threadName);
            thread.start();
        }
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

    class ThreadRun implements Runnable {

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
                    logger.trace("执行任务 任务<" + taskHandler.getID() + ">: " + taskHandler.getName() + " 耗时：" + (endTime - startTime));
                }
            }
        }
    }
}
