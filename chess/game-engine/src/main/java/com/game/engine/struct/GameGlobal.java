/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct;

import java.util.Random;

/**
 * 游戏常用全局数据
 */
public class GameGlobal {

    static GameGlobal instance = new GameGlobal();

    public static GameGlobal getInstance() {
        return instance;
    }
    private final ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");

    private final Object obj = new Object();

    private long staticID = 0;

    private int serverID = new Random().nextInt(1000);

    private boolean running = true;

    public ThreadGroup getGlobeThreadGroup() {
        return GlobeThreadGroup;
    }

    public long getCreateId() {
        synchronized (obj) {
            staticID += 1;
            return (serverID & 0xFFFF) << 48 | (System.currentTimeMillis() / 1000L & 0xFFFFFFFF) << 16 | staticID & 0xFFFF;
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void StopServer() {
        running = false;
    }

}
