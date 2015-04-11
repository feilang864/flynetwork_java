package com.game.engine.struct.thread;

import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;

/**
 * 定时器执行器
 */
public abstract class TimerEventRunnable extends DataRunnable {

    private static final long serialVersionUID = -8331296295264699207L;

    /**
     * 线程ID
     */
    private long tID;
    /**
     * 开始执行的时间
     */
    private long startTime;

    /**
     * 是否一开始执行一次
     */
    private boolean isStartAction;

    /**
     * 结束时间
     */
    private long endTime;

    /**
     * 执行次数
     */
    private int actionCount;

    /**
     * 间隔执行时间
     */
    private int intervalTime;

    /**
     *
     * @param tid
     * @param startTime
     * @param isStartAction
     * @param endTime
     * @param actionCount
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long tid, long startTime, boolean isStartAction, long endTime, int actionCount, int intervalTime, String Name) {
        super(Name);
        this.tID = tid;
        this.startTime = startTime;
        this.isStartAction = isStartAction;
        this.endTime = endTime;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param tid
     * @param startTime
     * @param isStartAction
     * @param endTime
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long tid, long startTime, boolean isStartAction, long endTime, int intervalTime, String Name) {
        super(Name);
        this.tID = tid;
        this.startTime = startTime;
        this.isStartAction = isStartAction;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param tid
     * @param isStartAction
     * @param actionCount
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long tid, boolean isStartAction, int actionCount, int intervalTime, String Name) {
        super(Name);
        this.tID = tid;
        this.isStartAction = isStartAction;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param tid
     * @param startTime
     * @param endTime
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long tid, long startTime, long endTime, int intervalTime, String Name) {
        super(Name);
        this.tID = tid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param tid 执行线程ID
     * @param startTime
     * @param actionCount
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long tid, long startTime, int actionCount, int intervalTime, String Name) {
        super(Name);
        this.tID = tid;
        this.startTime = startTime;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
    }

    public long gettID() {
        return tID;
    }

    public void settID(long tID) {
        this.tID = tID;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public boolean isIsStartAction() {
        return isStartAction;
    }

    public void setIsStartAction(boolean isStartAction) {
        this.isStartAction = isStartAction;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

}
