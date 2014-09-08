/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.map;

import com.game_engine.utils.ServerThread;

/**
 *
 * @author Administrator
 */
public class MapThread extends ServerThread {

    public MapThread(String name) {
        super(name);
        ThreadGroup threadGroup = new ThreadGroup(name);
        ServerThread threadPool = new ServerThread(threadGroup, name + "MainRunnable");
        ServerThread threadPool1 = new ServerThread(threadGroup, name + "TimerRunnable");
    }

}
