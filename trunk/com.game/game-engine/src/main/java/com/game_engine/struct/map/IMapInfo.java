/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.map;

/**
 * 包含地图信息
 *
 * @author fly_ty
 */
public interface IMapInfo {

    long mapId = 0;
    long serverId = 0;
    long lineId = 0;

    /**
     * 获取地图ID 运行时地图ID
     *
     * @return
     */
    long getMapId();

    /**
     * 获取服务器ID
     *
     * @return
     */
    long getServerId();

    /**
     * 获取所在地图的线
     *
     * @return
     */
    long getLineId();
}
