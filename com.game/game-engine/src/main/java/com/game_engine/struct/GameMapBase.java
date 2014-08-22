/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct;

import com.game_engine.threadpool.WorkerThread;
import org.apache.log4j.Logger;

/**
 * 地图线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameMapBase extends GameObject {

    Logger logger = Logger.getLogger(GameMapBase.class);

    WorkerThread workerThread = null;
    WorkerThread workerThread1 = null;

    public GameMapBase(Long ID, String mapName) {
        this.setID(ID);
        this.setName(mapName);
        workerThread = WorkerThread.GetInstance(mapName + "_Main");
        workerThread1 = WorkerThread.GetInstance(mapName + "_1线");
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineId
     * @param run
     */
    public void addMessage(int lineId, GameRunnable run) {

        switch (lineId) {
            case 0:
                workerThread.addTask(run);
                break;
            case 1:
                workerThread1.addTask(run);
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
    }

    @Override
    public String toString() {
        return "地图线程{ID=" + this.getID() + ", 名称=" + this.getName() + '}';
    }

}
