/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.struct.map;

import fly.game.engine.struct.ObjectBase;

/**
 * 地图精灵对象
 *
 * @author Troy.Chen
 */
public class MapSpirit extends ObjectBase {

    private static final long serialVersionUID = 591540596011671140L;
    private Position position;
    private long mapId;
    private int mapModelId;
    private int lineId;
    private int serverId;

    public MapSpirit() {
    }

    public MapSpirit(Position position) {
        this.position = position;
    }

    public MapSpirit(Position position, String Name) {
        super(Name);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public int getMapModelId() {
        return mapModelId;
    }

    public void setMapModelId(int mapModelId) {
        this.mapModelId = mapModelId;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

}
