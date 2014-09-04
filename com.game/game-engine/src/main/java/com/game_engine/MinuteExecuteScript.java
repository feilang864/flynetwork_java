/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine;

import java.util.concurrent.ScheduledExecutorService;

/**
 * 分钟执行脚本任务
 *
 * @author Troy.Chen
 * @phone 1388212209
 */
public class MinuteExecuteScript {

    int minute = 1;
    ScheduledExecutorService scheduler;

    /**
     * 分钟执行脚本任务
     *
     */
    public MinuteExecuteScript() {
//        ///创建10个线程，创建的线程数量
//        Executor executor = Executors.newFixedThreadPool(1);
//        ///指定任务
//        executor.execute(this);
//        ///预订线程，数量
//        executor = Executors.newScheduledThreadPool(1);
//        ///线程执行服务
//        scheduler = (ScheduledExecutorService) executor;
//        scheduler.scheduleAtFixedRate(this, minute, minute, TimeUnit.MINUTES);
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
