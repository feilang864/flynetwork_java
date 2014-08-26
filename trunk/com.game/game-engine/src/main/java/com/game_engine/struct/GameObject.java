/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct;

import java.util.Random;

/**
 * 一切父类
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameObject {

    public GameObject() {
        ID = 0L;
    }

    private static final Object obj = new Object();

    private static long staticID = 0;

    private static int serverID = new Random().nextInt(1000000);

    public static long getId() {
        synchronized (obj) {
            staticID += 1;
            return (serverID & 0xFFFF) << 48 | (System.currentTimeMillis() / 1000L & 0xFFFFFFFF) << 16 | staticID & 0xFFFF;
        }
    }

    public GameObject(Long ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    private Long ID;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "{" + "ID=" + ID + ", Name=“" + Name + "”}";
    }

}
