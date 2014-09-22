/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.map;

import com.game_engine.struct.GameObject;
import com.game_engine.struct.GameRunnable;
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

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(GameMapBase.class);

    long threadID[] = new long[7];

    public GameMapBase(String mapName) {
        super(mapName);
        ThreadGroup tempThreadGroup = new ThreadGroup(ThreadUtil.MapThreadGroup, mapName);
        threadID[0] = ThreadUtil.getWorkerThread(tempThreadGroup, "Main");
        threadID[1] = ThreadUtil.getWorkerThread(tempThreadGroup, "怪物AI");
        threadID[2] = ThreadUtil.getWorkerThread(tempThreadGroup, "移动同步");
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineId
     * @param run
     */
    public void addMessage(int lineId, GameRunnable run) {
        ThreadUtil.addTask(threadID[lineId], run);
    }

    @Override
    public String toString() {
        return "地图线程{ID=" + this.getID() + ", 名称=" + this.getName() + '}';
    }

}
