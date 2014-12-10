/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine;

import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.TaskHandlerBase;
import fly.com.object_engine.thread.TaskThread;

/**
 *
 * @author Administrator
 */
public class MapMainThread extends TaskThread {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TaskThread.class);
    private static final ThreadGroup THREAD_GROUP = new ThreadGroup(ObjectConfig.getThreadGroup(), "地图线程");

    public MapMainThread() {
        super(THREAD_GROUP, "全局地图线程执行器");
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
                if (endTime - startTime > 3000) {
                    logger.info("全局地图线程执行器执行任务 任务<" + taskHandler.getID() + ">: " + taskHandler.getName() + " 耗时：" + (endTime - startTime));
                }
            }
        }
    }
}
