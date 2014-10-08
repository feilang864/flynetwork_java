/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine;

import flynetwork.com.data.engine.manager.MapManager;
import flynetwork.com.data.engine.struct.map.GameMapBase;
import flynetwork.com.data.engine.manager.ThreadManager;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {
        ThreadManager.getInstance();
        MapManager.getInstance().addMap(new GameMapBase(1, 3, "新手村") {
            private static final long serialVersionUID = 1L;
        });
        MapManager.getInstance().addMap(new GameMapBase(2, 2, "金银岛") {
            private static final long serialVersionUID = 1L;
        });
        MapManager.getInstance().addMap(new GameMapBase(4, 2, "神木村") {
            private static final long serialVersionUID = 1L;
        });
        MapManager.getInstance().addMap(new GameMapBase(5, 2, "地球防御本部") {
            private static final long serialVersionUID = 1L;
        });
    }
}
