/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.timetask;

import com.game_engine.struct.GameRunnable;
import java.util.concurrent.ScheduledExecutorService;
import org.apache.log4j.Logger;

/**
 * 定时器执行器
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class TimerEvent extends GameRunnable {

    private static final Logger logger = Logger.getLogger(TimerEvent.class);
    int minute = 1;
    long endtime = 0;
    int execcount = 0;
    int jiangetime = 0;
    ScheduledExecutorService scheduler;

    public TimerEvent(long endtime, int execcount, int jiangetime, String Name) {
        super(Name);
        this.endtime = endtime;
        this.execcount = execcount;
        this.jiangetime = jiangetime;
    }

    /**
     * 分钟执行脚本任务
     *
     */
    //public TimerEvent() {
//        ///创建10个线程，创建的线程数量
//        Executor executor = Executors.newFixedThreadPool(1);
//        ///指定任务
//        executor.execute(this);
//        ///预订线程，数量
//        executor = Executors.newScheduledThreadPool(1);
//        ///线程执行服务
//        scheduler = (ScheduledExecutorService) executor;
//        scheduler.scheduleAtFixedRate(this, minute, minute, TimeUnit.MINUTES);
    //}
    public void shutdown() {
        scheduler.shutdown();
    }
}
