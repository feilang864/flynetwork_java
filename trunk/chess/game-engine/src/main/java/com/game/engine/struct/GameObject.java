/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct;

import java.io.Serializable;

/**
 * 基类
 */
public abstract class GameObject implements Serializable {

    private static final long serialVersionUID = 6613390145680665678L;

    public GameObject() {
        this(GameGlobal.getInstance().getCreateId(), "");
    }

    public GameObject(String Name) {
        this(GameGlobal.getInstance().getCreateId(), Name);
    }

    public GameObject(long ID, String Name) {
        this.ID = ID;
        this.Name = Name;
        tempAttribute = new GameAttribute();
    }

    private Long ID;
    private String Name;
    //
    private transient GameAttribute tempAttribute = new GameAttribute();

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
