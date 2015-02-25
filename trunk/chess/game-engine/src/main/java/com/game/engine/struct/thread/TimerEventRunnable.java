package com.game.engine.struct.thread;

/**
 * 定时器执行器
 */
public abstract class TimerEventRunnable extends DataRunnable {

    private static final long serialVersionUID = -8331296295264699207L;

    /// <summary>
    /// 开始执行的时间
    /// </summary>
    private long startTime;

    /// <summary>
    /// 是否一开始执行一次
    /// </summary>
    private boolean isStartAction;

    /// <summary>
    /// 结束时间
    /// </summary>
    private long endTime;

    /// <summary>
    /// 执行次数
    /// </summary>
    private int actionCount;

    /// <summary>
    /// 间隔执行时间
    /// </summary>
    private int intervalTime;

    /**
     *
     * @param startTime
     * @param isStartAction
     * @param endTime
     * @param actionCount
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long startTime, boolean isStartAction, long endTime, int actionCount, int intervalTime, String Name) {
        super(Name);
        this.startTime = startTime;
        this.isStartAction = isStartAction;
        this.endTime = endTime;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param startTime
     * @param isStartAction
     * @param endTime
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long startTime, boolean isStartAction, long endTime, int intervalTime, String Name) {
        super(Name);
        this.startTime = startTime;
        this.isStartAction = isStartAction;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param isStartAction
     * @param actionCount
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(boolean isStartAction, int actionCount, int intervalTime, String Name) {
        super(Name);
        this.isStartAction = isStartAction;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param startTime
     * @param endTime
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long startTime, long endTime, int intervalTime, String Name) {
        super(Name);
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
    }

    /**
     *
     * @param startTime
     * @param actionCount
     * @param intervalTime
     * @param Name
     */
    public TimerEventRunnable(long startTime, int actionCount, int intervalTime, String Name) {
        super(Name);
        this.startTime = startTime;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
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
