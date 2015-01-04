/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.thread;

/**
 *
 * @author Administrator
 */
public abstract class TimeTaskHandlerBase extends TaskHandlerBase {

    private static final long serialVersionUID = 5037670214201844427L;
    //开始时间
    private long startTime;
    //是否一开始执行一次
    private boolean startAction;
    //结束时间
    private long endTime;
    //执行次数
    private int actionCount;
    //间隔执行时间
    private int intervalTime;

    /**
     * 永久间隔时间执行
     *
     * @param startTime
     * @param isStartAction
     * @param intervalTime
     */
    public TimeTaskHandlerBase(long startTime, boolean isStartAction, int intervalTime) {
        this(startTime, isStartAction, 0L, 0, intervalTime, 0);
    }

    /**
     * 永久间隔时间执行
     *
     * @param startTime
     * @param startAction
     * @param intervalTime
     * @param name
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, int intervalTime, String name) {
        this(startTime, startAction, 0L, 0, intervalTime, 0, name);
    }

    /**
     * 指定执行次数的任务
     *
     * @param startTime
     * @param startAction
     * @param actionCount
     * @param intervalTime
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, int actionCount, int intervalTime) {
        this(startTime, startAction, 0L, actionCount, intervalTime, 0);
    }

    /**
     * 指定结束时间的任务
     *
     * @param startTime
     * @param startAction
     * @param endTime
     * @param intervalTime
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, long endTime, int intervalTime) {
        this(startTime, startAction, endTime, 0, intervalTime, 0);
    }

    /**
     * 指定执行次数的任务
     *
     * @param startTime
     * @param startAction
     * @param actionCount
     * @param intervalTime
     * @param actionThreadId
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, int actionCount, int intervalTime, int actionThreadId) {
        this(startTime, startAction, 0, actionCount, intervalTime, actionThreadId);
    }

    /**
     * 指定结束时间的任务
     *
     * @param startTime 开始时间
     * @param startAction 是否加入队列前执行一次
     * @param endTime 结束时间
     * @param intervalTime 间隔时间
     * @param actionThreadId 执行线程
     * @param Name 任务名字
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, long endTime, int intervalTime, int actionThreadId, String Name) {
        this(startTime, startAction, endTime, 0, intervalTime, actionThreadId, Name);
    }

    /**
     * 指定结束时间的任务
     *
     * @param startTime 开始时间
     * @param startAction 是否加入队列前执行一次
     * @param endTime 结束时间
     * @param intervalTime 间隔时间
     * @param Name 任务名字
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, long endTime, int intervalTime, String Name) {
        this(startTime, startAction, endTime, 0, intervalTime, 0, Name);
    }

    /**
     * 指定执行次数的任务
     *
     * @param startTime
     * @param startAction
     * @param actionCount
     * @param intervalTime
     * @param actionThreadId
     * @param Name
     */
    public TimeTaskHandlerBase(long startTime, boolean startAction, int actionCount, int intervalTime, int actionThreadId, String Name) {
        this(startTime, startAction, 0, actionCount, intervalTime, actionThreadId, Name);
    }

    private TimeTaskHandlerBase(long startTime, boolean startAction, long endTime, int actionCount, int intervalTime, int actionThreadId) {
        this(startTime, startAction, endTime, actionCount, intervalTime, actionThreadId, null);
    }

    private TimeTaskHandlerBase(long startTime, boolean startAction, long endTime, int actionCount, int intervalTime, int actionThreadId, String Name) {
        super(actionThreadId, Name);
        this.startTime = startTime;
        this.startAction = startAction;
        this.endTime = endTime;
        this.actionCount = actionCount;
        this.intervalTime = intervalTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public boolean isStartAction() {
        return startAction;
    }

    public void setStartAction(boolean startAction) {
        this.startAction = startAction;
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

    @Override
    public String toString() {
        return "{" + super.toString() + ", 指定开始时间=" + startTime + ", 指定结束时间=" + endTime + ", 指定执行次数=" + actionCount + ", 指定间隔时间=" + intervalTime + '}';
    }

}
