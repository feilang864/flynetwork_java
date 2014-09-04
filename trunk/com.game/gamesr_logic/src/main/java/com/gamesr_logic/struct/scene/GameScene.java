/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesr_logic.struct.scene;

import com.game_engine.struct.GameObject;

/**
 * 场景对象
 *
 * @author Administrator
 */
public class GameScene extends GameObject {

    private float pX;
    private float pY;
    private int modelID;

    public GameScene() {
    }

    public GameScene(float pX, float pY, int modelID, String Name) {
        super(Name);
        this.pX = pX;
        this.pY = pY;
        this.modelID = modelID;
    }

    /**
     * 场景中的 X 坐标
     *
     * @return
     */
    public float getpX() {
        return pX;
    }

    /**
     * 场景中的 X 坐标
     *
     * @param pX
     */
    public void setpX(float pX) {
        this.pX = pX;
    }

    /**
     * 场景中的 Y 坐标
     *
     * @return
     */
    public float getpY() {
        return pY;
    }

    /**
     * 场景中的 Y 坐标
     *
     * @param pY
     */
    public void setpY(float pY) {
        this.pY = pY;
    }

    public int getModelID() {
        return modelID;
    }
}
