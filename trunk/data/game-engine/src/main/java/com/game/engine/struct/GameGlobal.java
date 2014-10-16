/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct;

/**
 * 游戏常用全局数据
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class GameGlobal {

    static GameGlobal instance = new GameGlobal();

    public static GameGlobal getInstance() {
        return instance;
    }
    private final ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");

    public ThreadGroup getGlobeThreadGroup() {
        return GlobeThreadGroup;
    }

    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void StopServer() {
        running = false;
    }

}
