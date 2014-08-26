/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.struct;

import java.util.Date;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameRunnable extends GameObject implements Runnable {

    /* 提交执行时间 */
    private long submitTime = 0;
    /* 执行完成时间 */
    private long finishTime = 0;

    static long taskIDL = 0;

    public GameRunnable() {
        super(++taskIDL, "测试");
        this.submitTime = System.currentTimeMillis();
    }

    public GameRunnable(String Name) {
        super(++taskIDL, Name);
        this.submitTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "GameRunnable{" + super.toString() + ", 提交时间=" + submitTime + ", 完成时间=" + finishTime + '}';
    }

    /**
     * 获取完成时间
     *
     * @return
     */
    public long getFinishTime() {
        return finishTime;
    }

    /**
     * 完成任务
     */
    public void setFinishTime() {
        this.finishTime = System.currentTimeMillis();
    }

    /**
     * 获取提交任务的时间
     *
     * @return
     */
    public long getSubmitTime() {
        return submitTime;
    }
}
