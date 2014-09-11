/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * 属性类
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class GameAttribute {

    Map<String, Object> attributesMap = new HashMap<>();

    public GameAttribute() {
    }

    public Object getValue(String key) {
        return attributesMap.get(key);
    }

    public void setValue(String key, Object attribute) {
        this.attributesMap.put(key, attribute);
    }

    public int getIntValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (int) (attributesMap.get(key));
        }
        return 0;
    }

    public String getStringValue(String key) {
        if (attributesMap.containsKey(key)) {
            return attributesMap.get(key).toString();
        }
        return null;
    }

    public long getLongValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (long) (attributesMap.get(key));
        }
        return 0;
    }

    public float getFloatValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (float) (attributesMap.get(key));
        }
        return 0;
    }

    public Boolean getBooleanValue(String key) {
        if (attributesMap.containsKey(key)) {
            return (boolean) (attributesMap.get(key));
        }
        return null;
    }
}
