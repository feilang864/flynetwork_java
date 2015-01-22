/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct.thread;

import org.apache.log4j.Logger;

/**
 * 定时器执行器
 */
public abstract class TimerEventRunnable extends DataRunnable {

    private static final Logger logger = Logger.getLogger(TimerEventRunnable.class);
    private static final long serialVersionUID = -8331296295264699207L;

    private boolean initExec;
    private int execcount;
    private long jiangetime;

    public boolean isInitExec() {
        return initExec;
    }

    public int getExeccount() {
        return execcount;
    }

    public long getJiangetime() {
        return jiangetime;
    }

    public void setExeccount(int execcount) {
        this.execcount = execcount;
    }

    /**
     * 全局执行，所有地图的地图线会执行的定时器
     *
     * @param initExec 是否初始化执行一次
     * @param execcount 执行次数 无限制 -1
     * @param jiangetime 间隔执行时间 最短5毫秒
     * @param Name 任务名称
     */
    public TimerEventRunnable(boolean initExec, int execcount, long jiangetime, String Name) {
        super(Name);
        this.initExec = initExec;
        this.execcount = execcount;
        this.jiangetime = jiangetime;

        if (initExec) {
            this.run();
        }
    }

    /**
     * 全局执行，所有地图的地图线会执行的定时器
     *
     * @param initExec
     * @param execcount
     * @param jiangetime
     * @param serverId
     * @param mapId
     * @param lineId
     * @param Name
     */
    public TimerEventRunnable(boolean initExec, int execcount, long jiangetime, int serverId, long mapId, long lineId, String Name) {
        this(initExec, execcount, jiangetime, Name);

    }
}
