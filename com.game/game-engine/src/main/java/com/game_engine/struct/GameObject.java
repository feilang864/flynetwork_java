/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct;

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
        return "GameObject{" + "ID=" + ID + ", Name=" + Name + '}';
    }

}
