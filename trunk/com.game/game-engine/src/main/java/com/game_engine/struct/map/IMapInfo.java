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

    /**
     * 
     * @param serverId 
     */
    void setServerId(int serverId);

    /**
     * 
     * @param mapId 
     */
    void setMapId(int mapId);

    /**
     * 
     * @param lineId 
     */
    void setLineId(int lineId);

    /**
     * 获取服务器ID
     *
     * @return
     */
    int getServerId();

    /**
     * 获取地图ID 运行时地图ID
     *
     * @return
     */
    int getMapId();

    /**
     * 获取所在地图的线
     *
     * @return
     */
    int getLineId();
}
