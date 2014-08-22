/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadmodel;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.game.game_engine.struct.BaseTask;
import org.game.game_engine.struct.GameObject;
import org.game.game_engine.utils.ThreadUtil;

/**
 * 地图线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MapThread extends GameObject {

    /**
     * 地图执行线程
     */
    class MapRunnable extends GameObject implements Runnable {

        public MapRunnable(long id, String name) {
            name = name + "线程";
            this.setName(name);
            this.setID(id);
            taskQueue = Collections.synchronizedList(new LinkedList<BaseTask>());
            logger.info(name + " 启动");
        }

        /* 任务列表 */
        private final List<BaseTask> taskQueue;

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param newTask
         */
        public void addTask(BaseTask newTask) {
            synchronized (taskQueue) {
                newTask.setSubmitTime(new Date());
                taskQueue.add(newTask);
                /* 唤醒队列, 开始执行 */
                taskQueue.notify();
            }
            logger.debug("提交任务 任务<" + newTask.getTaskId() + ">: " + newTask.info());
        }

        @Override
        public void run() {
            while (ThreadUtil.isRunning()) {
                BaseTask r = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && ThreadUtil.isRunning()) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(2000);
                        } catch (InterruptedException ie) {
                            logger.error(ie);
                        }
                    }
                }
                /* 取出任务执行 */
                if (ThreadUtil.isRunning()) {
                    r = taskQueue.remove(0);
                    if (r != null) {
                        try {
                            r.setBeginExceuteTime(new Date());
                            logger.info("工人<“" + this.getName() + "”> 开始消息处理<" + r.getTaskId() + "(“" + r.info() + "”)> 等待(“" + (r.getBeginExceuteTime().getTime() - r.getSubmitTime().getTime()) + "”ms)");
                            /* 执行任务 */
                            r.run();
                            r.setFinishTime(new Date());
                            logger.info("工人<“" + this.getName() + "”> 完成消息处理<" + r.getTaskId() + "(“" + r.info() + "”)>" + " 耗时(“" + (r.getFinishTime().getTime() - r.getBeginExceuteTime().getTime()) + "”ms)");
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("工人<“" + this.getName() + "”> 执行消息处理<" + r.getTaskId() + "(“" + r.info() + "”)> Error " + e);
                        }
                        r = null;
                    }
                }
            }
            logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
        }
    }

    Logger logger = Logger.getLogger(MapThread.class);

    WorkerThread workerThread = null;
    WorkerThread workerThread1 = null;
    GameObject gameMap;

    private MapThread(GameObject gamemap) {
        gameMap = gamemap;
        String mapName = "地图：" + gameMap.getName();
        this.setName(mapName);

        workerThread = new WorkerThread(new MapRunnable(1, mapName + "_Main"));
        workerThread1 = new WorkerThread(new MapRunnable(2, mapName + "_1线"));
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineId
     * @param newTask
     */
    public void addTask(int lineId, BaseTask newTask) {
        MapRunnable mapRunnable = null;
        switch (lineId) {
            case 0:
                mapRunnable = (MapRunnable) workerThread.getTarget();
                break;
            case 1:
                mapRunnable = (MapRunnable) workerThread1.getTarget();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
        }
        mapRunnable.addTask(newTask);
    }

    public static MapThread GetInstance(GameObject gameMap) {
        return new MapThread(gameMap);
    }

    @Override
    public String toString() {
        return "MapThread{" + super.toString() + ", workerThread=" + workerThread + '}';
    }

}
