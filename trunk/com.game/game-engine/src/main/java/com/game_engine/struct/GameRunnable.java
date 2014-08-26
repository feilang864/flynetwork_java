/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct;

import org.apache.log4j.Logger;

/**
 * 任务执行
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameRunnable extends GameObject implements Runnable {

    final Logger logger = Logger.getLogger(GameRunnable.class);

    long submitTimeL;

    long finishTimeL;

    private GameRunnable(Long ID, String Name) {
        super(ID, Name);
        submitTimeL = System.currentTimeMillis();
        synchronized (runID) {
            if (runID + 1 >= Long.MAX_VALUE) {
                runID = 0L;
            }
        }
    }

    static Long runID = 0L;

    public GameRunnable(String Name) {
        this(++runID, Name);
    }

    public long getSubmitTimeL() {
        return submitTimeL;
    }

    public void setSubmitTimeL() {
        this.submitTimeL = System.currentTimeMillis();
    }

    public long getFinishTimeL() {
        return finishTimeL;
    }

    public void setFinishTimeL() {
        this.finishTimeL = System.currentTimeMillis();
    }

}
