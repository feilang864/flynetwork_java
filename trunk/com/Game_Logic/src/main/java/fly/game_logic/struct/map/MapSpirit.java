/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic.struct.map;

import fly.com.object_engine.struct.ObjectBase;
import fly.game_logic.struct.Position;

/**
 * 地图精灵对象
 *
 * @author Administrator
 */
public class MapSpirit extends ObjectBase {

    private static final long serialVersionUID = 591540596011671140L;
    private Position position;

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

}
