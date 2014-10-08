/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.manager;

import flynetwork.com.data.engine.struct.map.GameMapBase;
import flynetwork.com.data.engine.struct.thread.GameRunnable;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class MapManager {

    private static final Logger logger = Logger.getLogger(MapManager.class);

    static MapManager instance = new MapManager();

    public static MapManager getInstance() {
        return instance;
    }

    public MapManager() {
        gameMaphHashMap = new HashMap<>();
    }

    HashMap<Long, GameMapBase> gameMaphHashMap;

    public boolean addMap(GameMapBase gameMap) {
        gameMaphHashMap.put(gameMap.getID(), gameMap);
        return true;
    }

    /**
     * 增加消息
     *
     * @param mapid
     * @param lineid
     * @param run
     * @return
     */
    public boolean addMessage(long mapid, long lineid, GameRunnable run) {
        if (gameMaphHashMap.containsKey(mapid)) {
            gameMaphHashMap.get(mapid).addMessage(lineid, run);
        } else if (mapid == 0) {
            for (Map.Entry<Long, GameMapBase> entry : gameMaphHashMap.entrySet()) {
                entry.getValue().addMessage(0, run);
            }
        }
        return true;
    }

    /**
     *
     * @param mapid
     * @param lineid
     * @param run
     * @return
     */
    public static boolean registerMessage(long mapid, int lineid, GameRunnable run) {

        return true;
    }
}
