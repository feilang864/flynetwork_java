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
import org.game.game_engine.struct.BaseMap;
import org.game.game_engine.struct.BaseTask;
import org.game.game_engine.struct.GameObject;
import org.game.game_engine.struct.GameRunnable;
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
            taskQueue = Collections.synchronizedList(new LinkedList<GameRunnable>());
            logger.info(name + " 启动");
        }

        /* 任务列表 */
        private final List<GameRunnable> taskQueue;

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param newTask
         */
        public void addTask(GameRunnable newTask) {
            synchronized (taskQueue) {

                taskQueue.add(newTask);
                /* 唤醒队列, 开始执行 */
                taskQueue.notify();
            }
            logger.debug("提交任务 任务<" + newTask.getID() + ">: " + newTask.getName());
        }

        @Override
        public void run() {
            while (ThreadUtil.isRunning()) {
                GameRunnable r = null;
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
                            /* 执行任务 */
                            r.run();
                            r.setFinishTime();
                            logger.debug("工人<“" + this.getName() + "”> 完成了任务：" + r.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("工人<“" + this.getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
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

    private MapThread(Long ID, String name) {
        String mapName = "地图：" + name;
        this.setID(ID);
        this.setName(mapName);

        workerThread = new WorkerThread(mapName + "_Main", new MapRunnable(1, mapName + "_Main"));
        workerThread1 = new WorkerThread(mapName + "_1线", new MapRunnable(2, mapName + "_1线"));
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineId
     * @param newTask
     */
    public void addMessage(int lineId, GameRunnable run) {
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
        mapRunnable.addTask(run);
    }

    public static MapThread GetInstance(Long id, String name) {
        return new MapThread(id, name);
    }

    @Override
    public String toString() {
        return "MapThread{" + super.toString() + ", workerThread=" + workerThread + '}';
    }

}
