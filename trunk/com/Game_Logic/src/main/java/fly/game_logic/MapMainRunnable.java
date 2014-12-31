/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic;

import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.RunnableBase;
import fly.com.object_engine.thread.TaskHandlerBase;

/**
 *
 * @author Administrator
 */
public class MapMainRunnable extends RunnableBase {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MapMainRunnable.class);
    private static final ThreadGroup THREAD_GROUP = new ThreadGroup(ObjectConfig.getThreadGroup(), "地图线程");
    private static final long serialVersionUID = 2023779598655324836L;

    public MapMainRunnable() {
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
                //if (endTime - startTime > 3000) {
                logger.info("全局地图线程执行器执行任务 任务<" + taskHandler.getID() + ">: " + taskHandler.getName() + " 耗时：" + (endTime - startTime));
                //}
            }
        }
    }
}
