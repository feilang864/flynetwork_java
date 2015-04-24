/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sz.pool;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class ObjectGlobal {

    static ObjectGlobal instance = new ObjectGlobal();

    public static ObjectGlobal getInstance() {
        return instance;
    }

    private final Object obj = new Object();

    private long staticID = 0;

    //默认值而已
    private int serverID = new Random().nextInt(1000);

    public int getServerID() {
        return serverID;
    }

    public void setServerID(int serverID) {
        this.serverID = serverID;
    }

    /**
     * 返回每秒65535个无规则ID
     *
     * @return
     */
    public long getCreateId() {
        synchronized (obj) {
            staticID += 1;
            return (serverID & 0xFFFF) << 48 | (System.currentTimeMillis() / 1000L & 0xFFFFFFFF) << 16 | staticID & 0xFFFF;
        }
    }

}
