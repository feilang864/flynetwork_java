/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

import com.game.engine.struct.GameObject;
import org.apache.log4j.Logger;

/**
 * 任务执行
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class DataRunnable extends GameObject implements Runnable {

    private static final long serialVersionUID = -6366203475094728409L;

    private static final Logger logger = Logger.getLogger(DataRunnable.class);

    long submitTime;

    long finishTime;

    /**
     *
     * @param Name 任务名称
     */
    public DataRunnable(String Name) {
        super(Name);
        submitTime = System.currentTimeMillis();
    }

    public long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime() {
        this.submitTime = System.currentTimeMillis();
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime() {
        this.finishTime = System.currentTimeMillis();
    }

}
