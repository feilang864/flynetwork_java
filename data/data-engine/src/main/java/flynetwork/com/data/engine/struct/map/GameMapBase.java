/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.struct.map;

import flynetwork.com.data.engine.manager.ThreadManager;
import flynetwork.com.data.engine.struct.DataObject;
import flynetwork.com.data.engine.struct.thread.DataRunnable;
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
public abstract class GameMapBase extends DataObject {

    private static final long serialVersionUID = -7873171982824356220L;
    private static final ThreadGroup MAP_THREAD_GROUP = new ThreadGroup("地图线程");

    class GameMapLine extends DataObject implements IMapInfo {

        private static final long serialVersionUID = 6142938426497360665L;

        //主线程
        long mapThreadMain;
        //怪物AI同步线程
        long mapThreadMonsterAI;
        //移动线程
        long mapThreadMove;

        int serverId;
        long mapId;
        long lineId;

        public GameMapLine(ThreadGroup threadGroup, int serverid, long mapId, int lineId, String mapName) {
            super(lineId, mapName);
            this.lineId = lineId;
            this.mapId = mapId;
            this.serverId = serverid;
            ThreadGroup tempThreadGroup = new ThreadGroup(threadGroup, mapName);
            logger.info("加载地图：" + mapName + " 阻挡信息");
            logger.info("地图：" + mapName + " 创建完成");
            mapThreadMain = ThreadManager.getInstance().getMapThread(tempThreadGroup, "Main——线程");
            mapThreadMonsterAI = ThreadManager.getInstance().getMapThread(tempThreadGroup, "怪物AI——线程");
            mapThreadMain = ThreadManager.getInstance().getMapThread(tempThreadGroup, "移动——线程");
        }

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param run
         */
        public void addMessage(DataRunnable run) {
            ThreadManager.getInstance().addTask(this.mapThreadMain, run);
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
        public long getMapId() {
            return mapId;
        }

        @Override
        public long getLineId() {
            return lineId;
        }

        @Override
        public void setServerId(int serverId) {
            this.serverId = serverId;
        }

        @Override
        public void setMapId(long mapId) {
            this.mapId = mapId;
        }

        @Override
        public void setLineId(long lineId) {
            this.lineId = lineId;
        }

    }

    private static final Logger logger = Logger.getLogger(GameMapBase.class);

    Map<Long, GameMapLine> gameMap = new HashMap<>();

    private int mapModelID;

    public int getMapModelID() {
        return mapModelID;
    }

    /**
     *
     * @param serverid
     * @param mapModelId map的模板ID
     * @param lineCount map共有几条线
     * @param mapName map的名称
     */
    public GameMapBase(int serverid, int mapModelId, int lineCount, String mapName) {
        super(mapName);
        mapModelID = mapModelId;
        ThreadGroup mapGroup = new ThreadGroup(MAP_THREAD_GROUP, mapName);
        for (int i = 1; i <= lineCount; i++) {
            GameMapLine gameMapLine = new GameMapLine(mapGroup, serverid, this.getID(), i, mapName + " " + i + " 线");
            gameMap.put(gameMapLine.getID(), gameMapLine);
        }
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param lineid 分线ID
     * @param run 需要执行的任务
     */
    public void addMessage(long lineid, DataRunnable run) {
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
