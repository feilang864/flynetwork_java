/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.utils;

import org.apache.log4j.Logger;

/**
 * 计时任务利用器
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class TimerEventUtil {

    private static final Logger logger = Logger.getLogger(TimerEventUtil.class);

    private static final TimerEventUtil instace = new TimerEventUtil();

    private static TimerEventUtil getInstace() {
        return instace;
    }

    public TimerEventUtil() {
        ThreadUtil.getWorkerThread(ThreadUtil.GlobeThreadGroup, "全局定时器管理执行器");
    }

}
