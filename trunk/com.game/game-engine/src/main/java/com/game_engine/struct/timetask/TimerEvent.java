/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.timetask;

import com.game_engine.struct.GameRunnable;
import com.game_engine.struct.map.IMapInfo;
import java.util.concurrent.ScheduledExecutorService;
import org.apache.log4j.Logger;

/**
 * 定时器执行器
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class TimerEvent extends GameRunnable implements IMapInfo {

    private static final Logger logger = Logger.getLogger(TimerEvent.class);
    private static final long serialVersionUID = -8331296295264699207L;
    int minute = 1;
    long endtime = 0;
    int execcount = 0;
    int jiangetime = 0;
    int serverId = 0;
    int mapId = 0;
    int lineId = 0;
    ScheduledExecutorService scheduler;

    public TimerEvent(long endtime, int execcount, int jiangetime, String Name) {
        super(Name);
        this.endtime = endtime;
        this.execcount = execcount;
        this.jiangetime = jiangetime;
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    @Override
    public int getServerId() {
        return serverId;
    }

    @Override
    public int getMapId() {
        return mapId;
    }

    @Override
    public int getLineId() {
        return lineId;
    }
}
