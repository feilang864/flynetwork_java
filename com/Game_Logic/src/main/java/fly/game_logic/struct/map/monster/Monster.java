/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic.struct.map.monster;

import fly.game_logic.struct.BaseAttribute;
import fly.game_logic.struct.Position;
import fly.game_logic.struct.map.MapSpirit;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Monster extends MapSpirit {

    private static final long serialVersionUID = -5712525327400018621L;
    //计算属性
    private HashMap<Integer, BaseAttribute> attributesMap = new HashMap<>(0);
    //无需每次计算的设置属性
    private HashMap<Integer, BaseAttribute> otherAttributesMap = new HashMap<>(0);
    //最终属性
    private BaseAttribute finalAttribute = new BaseAttribute();

    public Monster() {
    }

    public Monster(String Name, Position position) {
        super(position, Name);
    }

    //<editor-fold defaultstate="collapsed" desc="属性构造器 getter   setter">
    public HashMap<Integer, BaseAttribute> getAttributesMap() {
        return attributesMap;
    }

    public void setAttributesMap(HashMap<Integer, BaseAttribute> attributesMap) {
        this.attributesMap = attributesMap;
    }

    public HashMap<Integer, BaseAttribute> getOtherAttributesMap() {
        return otherAttributesMap;
    }

    public void setOtherAttributesMap(HashMap<Integer, BaseAttribute> otherAttributesMap) {
        this.otherAttributesMap = otherAttributesMap;
    }

    public BaseAttribute getFinalAttribute() {
        return finalAttribute;
    }

    public void setFinalAttribute(BaseAttribute finalAttribute) {
        this.finalAttribute = finalAttribute;
    }
 //</editor-fold>

}
