/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.struct.thread;

import flynetwork.com.data.engine.struct.map.IMapInfo;
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

    private boolean initExec;
    private int execcount;
    private long jiangetime;
    private int serverId;
    private int mapId;
    private int lineId;

    /**
     * 全局执行，所有地图的地图线会执行的定时器
     *
     * @param initExec 是否初始化执行一次
     * @param execcount 执行次数 无限制 -1
     * @param jiangetime 间隔执行时间 最短5毫秒
     * @param Name 任务名称
     */
    public TimerEvent(boolean initExec, int execcount, long jiangetime, String Name) {
        super(Name);
        this.initExec = initExec;
        this.execcount = execcount;
        this.jiangetime = jiangetime;
        this.serverId = 0;
        this.mapId = 0;
        this.lineId = 0;
        if (initExec) {
            this.run();
        }
    }

    /**
     * 全局执行，所有地图的地图线会执行的定时器
     *
     * @param initExec
     * @param execcount
     * @param jiangetime
     * @param serverId
     * @param mapId
     * @param lineId
     * @param Name
     */
    public TimerEvent(boolean initExec, int execcount, long jiangetime, int serverId, int mapId, int lineId, String Name) {
        super(Name);
        this.initExec = initExec;
        this.execcount = execcount;
        this.jiangetime = jiangetime;
        this.serverId = serverId;
        this.mapId = mapId;
        this.lineId = lineId;
        if (initExec) {
            this.run();
        }
    }

    @Override
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    @Override
    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Override
    public void setLineId(int lineId) {
        this.lineId = lineId;
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
