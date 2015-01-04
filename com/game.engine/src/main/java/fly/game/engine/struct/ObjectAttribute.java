/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * 属性类
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class ObjectAttribute {

    private HashMap<String, Object> attributesMap = new HashMap<>(0);

    public HashMap<String, Object> getAttributesMap() {
        return attributesMap;
    }

    public void setAttributesMap(HashMap<String, Object> attributesMap) {
        this.attributesMap = attributesMap;
    }

    public ObjectAttribute() {
    }

    public Object get(String key) {
        return attributesMap.get(key);
    }

    public void put(String key, Object attribute) {
        this.attributesMap.put(key, attribute);
    }

    public int getintValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (int) (attributesMap.get(key));
        }
        return 0;
    }

    public Integer getIntegerValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (int) (attributesMap.get(key));
        }
        return null;
    }

    public double getdoubleValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (double) (attributesMap.get(key));
        }
        return 0.0;
    }

    public Double getDoubleValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (double) (attributesMap.get(key));
        }
        return null;
    }

    public String getStringValue(String key) {
        if (attributesMap.containsKey(key)) {
            return attributesMap.get(key).toString();
        }
        return null;
    }

    public long getlongValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (long) (attributesMap.get(key));
        }
        return 0;
    }

    public Long getLongValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (long) (attributesMap.get(key));
        }
        return null;
    }

    public float getfloatValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (float) (attributesMap.get(key));
        }
        return 0;
    }

    public Float getFloatValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (float) (attributesMap.get(key));
        }
        return null;
    }

    public boolean getbooleanValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (boolean) (attributesMap.get(key));
        }
        return false;
    }

    public Boolean getBooleanValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (boolean) (attributesMap.get(key));
        }
        return null;
    }

    @Override
    public String toString() {
        return attributesMap.toString();
    }

}
