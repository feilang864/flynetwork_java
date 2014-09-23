/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.thread;

import com.game_engine.struct.GameObject;

/**
 * 工作线程
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class ServerThread extends Thread {

    public ServerThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        id = GameObject.getId();
        start();
    }
    private long id;

    @Override
    public long getId() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "ServerThread{" + "id=" + id + '}';
    }

}
