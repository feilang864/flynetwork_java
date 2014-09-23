/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.map;

import com.game_engine.struct.GameObject;
import com.game_engine.struct.GameRunnable;
import com.game_engine.thread.map.MapThread;
import com.game_engine.utils.ThreadUtil;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * 地图线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameMapBase extends GameObject {

    private static final long serialVersionUID = -7873171982824356220L;

    class GameMapLine extends GameObject implements IMapInfo {

        private static final long serialVersionUID = 6142938426497360665L;
        //主线程
        MapThread mapThreadMain = null;
        //怪物AI同步线程
        MapThread mapThreadMonsterAI = null;
        //移动线程
        MapThread mapThreadMove = null;

        int serverId = 0;
        int mapId = 0;
        int lineId = 0;

        public GameMapLine(ThreadGroup threadGroup, long ID, String mapName) {
            super(ID, mapName);
            ThreadGroup tempThreadGroup = new ThreadGroup(threadGroup, mapName);
            logger.info("加载地图：" + mapName + " 阻挡信息");
            logger.info("地图：" + mapName + " 创建完成");
            mapThreadMain = MapThread.GetInstance(tempThreadGroup, "Main——线程");
            mapThreadMonsterAI = MapThread.GetInstance(tempThreadGroup, "怪物AI——线程");
            mapThreadMain = MapThread.GetInstance(tempThreadGroup, "移动——线程");
        }

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param run
         */
        public void addMessage(GameRunnable run) {
            //ThreadUtil.addTask(threadID[lineId], run);
            mapThreadMain.addTask(run);
        }

        @Override
        public String toString() {
            return "地图线程{ID=" + this.getID() + ", 名称=" + this.getName() + '}';
        }

        @Override
        public int getServerId() {
            return serverId;
        }

        @Override
        public int getMapId() {
            return mapId;
        }

        @Override
        public int getLineId() {
            return lineId;
        }

    }

    private static final Logger logger = Logger.getLogger(GameMapBase.class);

    Map<Long, GameMapLine> gameMap = new HashMap<>();

    public GameMapBase(int ID, int lineCount, String mapName) {
        super(ID, mapName);
        ThreadGroup mapGroup = new ThreadGroup(MapThread.getMAP_THREAD_GROUP(), mapName);
        for (int i = 1; i <= lineCount; i++) {
            GameMapLine gameMapLine = new GameMapLine(mapGroup, i, mapName + " " + i + "线");
            gameMap.put(gameMapLine.getID(), gameMapLine);
        }
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineid 分线ID
     * @param run 需要执行的任务
     */
    public void addMessage(long lineid, GameRunnable run) {
        if (lineid > 0) {
            gameMap.get(lineid).addMessage(run);
        } else if (lineid == 0) {
            for (Map.Entry<Long, GameMapLine> entry : gameMap.entrySet()) {
                entry.getValue().addMessage(run);
            }
        }
    }

    @Override
    public String toString() {
        return "地图线程{ID=" + this.getID() + ", 名称=" + this.getName() + '}';
    }

}
