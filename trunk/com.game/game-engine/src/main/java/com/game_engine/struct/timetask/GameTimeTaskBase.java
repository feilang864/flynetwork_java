/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.timetask;

import com.game_engine.struct.GameObject;
import java.util.concurrent.ScheduledExecutorService;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class GameTimeTaskBase extends GameObject {

    Logger logger = Logger.getLogger(GameTimeTaskBase.class);
    int minute = 1;
    ScheduledExecutorService scheduler;

    /**
     * 分钟执行脚本任务
     *
     */
    public GameTimeTaskBase() {
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

    public GameTimeTaskBase(String Name) {
        super(Name);
    }

}
