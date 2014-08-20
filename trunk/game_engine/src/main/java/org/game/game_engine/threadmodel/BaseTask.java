/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadmodel;

import java.util.Date;
import org.game.game_engine.stract.GameObject;

/**
 * 所有任务接口 其他任务必须继承访类
 *
 * @author Troy.Chen
 */
public abstract class BaseTask extends GameObject implements Runnable {

    private int ThreadID;

    /**
     * 设置执行线程ID
     *
     * @param ThreadID
     */
    public void setThreadID(int ThreadID) {
        this.ThreadID = ThreadID;
    }

    public int getThreadID() {
        return ThreadID;
    }

    /* 产生时间 */
    private Date generateTime = null;
    /* 提交执行时间 */
    private Date submitTime = null;
    /* 开始执行时间 */
    private Date beginExceuteTime = null;
    /* 执行完成时间 */
    private Date finishTime = null;
    /* 任务id */
    private long taskId;

    public BaseTask() {
        this.generateTime = new Date();
    }

    @Override
    public String toString() {
        return super.toString() + "BaseTask{" + "ThreadID=" + ThreadID + ", generateTime=" + generateTime + ", submitTime=" + submitTime + ", beginExceuteTime=" + beginExceuteTime + ", finishTime=" + finishTime + ", taskId=" + taskId + '}';
    }

    /**
     * 任务信息
     *
     * @return String
     */
    public abstract String info();

    public Date getGenerateTime() {
        return generateTime;
    }

    public Date getBeginExceuteTime() {
        return beginExceuteTime;
    }

    public void setBeginExceuteTime(Date beginExceuteTime) {
        this.beginExceuteTime = beginExceuteTime;
    }

    /**
     *
     * @return
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     *
     * @param finishTime
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取提交任务的时间
     *
     * @return
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

}
