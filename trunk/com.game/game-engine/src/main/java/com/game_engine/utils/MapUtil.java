/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.utils;

import com.game_engine.struct.map.GameMapBase;
import com.game_engine.struct.GameRunnable;
import java.util.HashMap;

/**
 * 地图管理器
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MapUtil {

    static HashMap<Long, GameMapBase> gameMaphHashMap = new HashMap<>();

    public static boolean addMap(GameMapBase gameMap) {
        gameMaphHashMap.put(gameMap.getID(), gameMap);
        return true;
    }

    /**
     * 增加消息
     *
     * @param mapid
     * @param run
     * @return
     */
    public static boolean addMessage(long mapid, long lineid, GameRunnable run) {
        if (gameMaphHashMap.containsKey(mapid)) {
            gameMaphHashMap.get(mapid).addMessage(lineid, run);
        } else {
            ThreadUtil.addBackTask(run);
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
