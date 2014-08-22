/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.game.game_engine.struct.BaseMap;
import org.game.game_engine.struct.BaseTask;
import org.game.game_engine.struct.GameObject;
import org.game.game_engine.struct.GameRunnable;
import org.game.game_engine.threadmodel.MapThread;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MapUtil {

    static HashMap<Long, BaseMap> gameMaphHashMap = new HashMap<>();

    public static boolean addMap(BaseMap gameMap) {
        gameMaphHashMap.put(gameMap.getID(), gameMap);
        return true;
    }

    /**
     *
     * @param mapid
     * @param lineid
     * @param run
     * @return
     */
    public static boolean registerMessage(Long mapid, int lineid, GameRunnable run) {
        gameMaphHashMap.get(mapid).addMessage(lineid, run);
        return true;
    }
}
