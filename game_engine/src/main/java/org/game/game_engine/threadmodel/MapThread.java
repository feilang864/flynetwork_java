/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadmodel;

import org.game.game_engine.struct.GameObject;

/**
 * 地图线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MapThread extends GameObject implements Runnable {

    public MapThread() {
        setName("万恶之林地图线程");
    }

    @Override
    public void run() {
        
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
