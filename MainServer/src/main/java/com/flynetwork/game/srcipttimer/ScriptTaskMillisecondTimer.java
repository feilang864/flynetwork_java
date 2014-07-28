/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.srcipttimer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 毫秒级脚本执行任务
 *
 * @author Troy.Chen
 */
public abstract class ScriptTaskMillisecondTimer implements Runnable {

    int _Millisecond = 5;

    /**
     * 初始化一个毫秒级脚本执行任务
     *
     * @param _millisecond 执行任务的毫秒数,不得低于5ms
     */
    public ScriptTaskMillisecondTimer(int _millisecond) {
        if (_millisecond < 5) {
            _millisecond = 5;
        }
        _Millisecond = _millisecond;
        ///创建10个线程，创建的线程数量
        Executor executor = Executors.newFixedThreadPool(1);
        ///指定任务
        executor.execute(this);
        ///预订线程，数量
        executor = Executors.newScheduledThreadPool(1);
        ///线程执行服务
        ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
        scheduler.scheduleAtFixedRate(this, 5, 5, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }

    @Override
    public abstract void run();

    public void shutdown()
    {
    
    }
    
}
