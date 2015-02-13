/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

/**
 * 任务执行
 */
public abstract class DataRunnable extends BaseRunnable {

    public DataRunnable() {
    }

    /**
     *
     * @param Name 任务名称
     */
    public DataRunnable(String Name) {
        super(Name);
        this.getTempAttribute().put("submitTime", System.currentTimeMillis());
    }

    public long getSubmitTime() {
        return this.getTempAttribute().getlongValue("submitTime");
    }

    @Override
    public String toString() {
        return "任务" + super.toString();
    }

}
