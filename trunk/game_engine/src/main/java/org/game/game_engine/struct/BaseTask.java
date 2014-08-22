/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.struct;

import java.util.Date;

/**
 * 所有任务接口 其他任务必须继承访类
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class BaseTask extends GameObject implements Runnable {

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

    static long taskIDL = 0;

    public BaseTask() {
        this.generateTime = new Date();
        taskId = ++taskIDL;
    }

    @Override
    public String toString() {
        return super.toString() + "BaseTask{generateTime=" + generateTime + ", submitTime=" + submitTime + ", beginExceuteTime=" + beginExceuteTime + ", finishTime=" + finishTime + ", taskId=" + taskId + '}';
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
