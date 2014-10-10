/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.manager;

import flynetwork.com.data.engine.struct.map.GameMapBase;
import flynetwork.com.data.engine.struct.map.IMapInfo;
import flynetwork.com.data.engine.struct.thread.DataRunnable;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MapManager {

    private static final Logger logger = Logger.getLogger(MapManager.class);

    static MapManager instance = new MapManager();

    public static MapManager getInstance() {
        return instance;
    }

    public MapManager() {
        gameMapHashMap = new HashMap<>();
    }

    HashMap<Long, GameMapBase> gameMapHashMap;

    public boolean addMap(GameMapBase gameMap) {
        gameMapHashMap.put(gameMap.getID(), gameMap);
        return true;
    }

    /**
     * 增加消息
     *
     * @param mapInfo
     * @param run
     * @return
     */
    public boolean addMessage(IMapInfo mapInfo, DataRunnable run) {
        if (mapInfo == null || mapInfo.getMapId() == 0) {
            for (Map.Entry<Long, GameMapBase> entry : gameMapHashMap.entrySet()) {
                entry.getValue().addMessage(0, run);
            }
        } else if (gameMapHashMap.containsKey(mapInfo.getMapId())) {
            gameMapHashMap.get(mapInfo.getMapId()).addMessage(mapInfo.getLineId(), run);
        } else {
            logger.error("地图管理器分派任务 未能找到地图 地图ID：" + mapInfo.getMapId());
        }
        return true;
    }

    public boolean addMessage(DataRunnable run) {
        ThreadManager.getInstance().addTask(run);
        return true;
    }

    public HashMap<Long, GameMapBase> getGameMapHashMap() {
        return gameMapHashMap;
    }

    public GameMapBase getGameMap(int mapModelid) {
        for (Map.Entry<Long, GameMapBase> entrySet : gameMapHashMap.entrySet()) {
            GameMapBase map = entrySet.getValue();
            if (map.getMapModelID() == mapModelid) {
                return map;
            }
        }
        return null;
    }

    public GameMapBase getGameMap(long mapid) {
        if (gameMapHashMap.containsKey(mapid)) {
            return gameMapHashMap.get(mapid);
        }
        return null;
    }
}
