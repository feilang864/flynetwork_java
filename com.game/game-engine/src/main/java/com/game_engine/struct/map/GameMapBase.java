/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.map;

import com.game_engine.struct.GameObject;
import com.game_engine.struct.GameRunnable;
import com.game_engine.poolthread.WorkerThread;
import com.game_engine.utils.ThreadUtil;
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

    long threadID[] = new long[7];

    public GameMapBase(Long ID, String mapName) {
        this.setID(ID);
        this.setName(mapName);
        threadID[0] = ThreadUtil.getWorkerThread(mapName + "_Main");
        threadID[1] = ThreadUtil.getWorkerThread(mapName + "_1线");
        threadID[2] = ThreadUtil.getWorkerThread(mapName + "_2线");
        threadID[3] = ThreadUtil.getWorkerThread(mapName + "_3线");
        threadID[4] = ThreadUtil.getWorkerThread(mapName + "_4线");
        threadID[5] = ThreadUtil.getWorkerThread(mapName + "_5线");
        threadID[6] = ThreadUtil.getWorkerThread(mapName + "_6线");
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineId
     * @param run
     */
    public void addMessage(int lineId, GameRunnable run) {
        ThreadUtil.getWorkHashMaps().get(threadID[lineId]).addTask(run);
    }

    @Override
    public String toString() {
        return "地图线程{ID=" + this.getID() + ", 名称=" + this.getName() + '}';
    }

}
