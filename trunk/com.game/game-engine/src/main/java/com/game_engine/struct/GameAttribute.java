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

    public Object getAttribute(String key) {
        return attributesMap.get(key);
    }

    public void setAttribute(String key, Object attribute) {
        this.attributesMap.put(key, attribute);
    }

}
