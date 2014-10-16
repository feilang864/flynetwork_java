/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct;

import java.io.Serializable;
import java.util.Random;

/**
 * 基类
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameObject implements Serializable {

    private static final long serialVersionUID = 6613390145680665678L;
    private static final Object obj = new Object();

    private static long staticID = 0;

    private static int serverID = new Random().nextInt(1000000);

    public static long getCreateId() {
        synchronized (obj) {
            staticID += 1;
            return (serverID & 0xFFFF) << 48 | (System.currentTimeMillis() / 1000L & 0xFFFFFFFF) << 16 | staticID & 0xFFFF;
        }
    }

    public GameObject() {
        this(getCreateId(), "");
    }

    public GameObject(String Name) {
        this(getCreateId(), Name);
    }

    public GameObject(long ID, String Name) {
        this.ID = ID;
        this.Name = Name;
        tempAttribute = new GameAttribute();
    }

    private Long ID;
    private String Name;
    //
    private transient GameAttribute tempAttribute;

    /**
     * 返回运行时属性值
     *
     * @return
     */
    public GameAttribute getTempAttribute() {
        return tempAttribute;
    }

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
        return "{" + "ID=" + ID + ", Name=" + Name + "}";
    }

}
