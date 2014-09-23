/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.map;

import com.game_engine.struct.GameObject;

/**
 *
 * @author fly_troy
 * @param <TPlayer> 玩家
 * @param <TDrop> 掉落物
 * @param <TMonster> 怪物
 * @param <TNpc> npc
 */
public class AreaInfo<TPlayer, TDrop, TMonster, TNpc> extends GameObject implements IMapInfo {

    private int serverId = 0;
    private int mapId = 0;
    private int lineId = 0;

    public AreaInfo(long ID, String Name) {
        super(ID, Name);
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
