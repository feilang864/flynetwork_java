/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

import com.game.engine.struct.GameObject;

/**
 * 任务执行
 */
public abstract class DataRunnable extends GameObject implements Runnable {

    private static final long serialVersionUID = -6366203475094728409L;

    /**
     *
     * @param Name 任务名称
     */
    public DataRunnable(String Name) {
        super(Name);
        this.getTempAttribute().put(" submitTime", System.currentTimeMillis());
    }

    public long getSubmitTime() {
        return this.getTempAttribute().getlongValue(" submitTime");
    }
}
