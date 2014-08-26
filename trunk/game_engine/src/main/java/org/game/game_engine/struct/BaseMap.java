/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.struct;

import org.game.game_engine.struct.GameObject;
import org.game.game_engine.threadmodel.MapThread;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class BaseMap extends GameObject {

    public BaseMap() {

    }

    MapThread mapThread;

    public BaseMap(Long ID, String Name) {
        super(ID, Name);
        mapThread = MapThread.GetInstance(ID, Name);

    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineId
     * @param newTask
     */
    public void addMessage(int lineId, GameRunnable newTask) {
        mapThread.addMessage(lineId, newTask);
    }

}
