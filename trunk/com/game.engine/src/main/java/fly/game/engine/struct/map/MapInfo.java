/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.struct.map;

import fly.game.engine.struct.ObjectBase;
import java.util.HashMap;

/**
 *
 * @author Troy.Chen
 */
public class MapInfo extends ObjectBase {

    private static final long serialVersionUID = -2787252326721917317L;
    private static final int Key_Monster = 1;
    private static final int Key_Npc = 2;
    private static final int Key_Player = 3;
    private int mapModelID;
    ///存储地图上的所有精灵对象
    private final HashMap<Long, HashMap<Long, MapSpirit>> spiritMap = new HashMap<>(0);

    private boolean enterMap(MapSpirit spirit) {
        return false;
    }
}
