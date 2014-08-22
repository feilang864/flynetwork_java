/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.utils;

import org.game.game_engine.struct.GameObject;
import org.game.game_engine.threadmodel.MapThread;

/**
 *
 * @author fly_troy
 */
public class MapUtil {

    public static boolean addMap(GameObject gameMap) {
        MapThread mapThread = MapThread.GetInstance(gameMap);
        return true;
    }
}
