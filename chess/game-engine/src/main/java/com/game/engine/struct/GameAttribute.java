/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.struct;

import java.util.HashMap;

/**
 * 属性类
 *
 */
public class GameAttribute extends HashMap<String, Object> {

    public GameAttribute() {
    }

//    public Class<? extends Object> remove(String key, Class<? extends Object> t) {
//        if (this.containsKey(key)) {
//            return (t)this.get(key);
//        }
//        return null;
//    }
    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public String getStringValue(String key) {
        if (this.containsKey(key)) {
            return this.get(key).toString();
        }
        return null;
    }

    /**
     * 如果未找到也返回 0
     *
     * @param key
     * @return
     */
    public int getintValue(String key) {
        if (this.containsKey(key)) {
            return (int) (this.get(key));
        }
        return 0;
    }

    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public Integer getIntegerValue(String key) {
        if (this.containsKey(key)) {
            return (Integer) (this.get(key));
        }
        return null;
    }

    /**
     * 如果未找到也返回 0
     *
     * @param key
     * @return
     */
    public long getlongValue(String key) {
        if (this.containsKey(key)) {
            return (long) (this.get(key));
        }
        return 0;
    }

    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public Long getLongValue(String key) {
        if (this.containsKey(key)) {
            return (Long) (this.get(key));
        }
        return null;
    }

    /**
     * 如果未找到也返回 0
     *
     * @param key
     * @return
     */
    public float getfloatValue(String key) {
        if (this.containsKey(key)) {
            return (float) (this.get(key));
        }
        return 0;
    }

    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public Float getFloatValue(String key) {
        if (this.containsKey(key)) {
            return (Float) (this.get(key));
        }
        return null;
    }

    /**
     * 如果未找到也返回 false
     *
     * @param key
     * @return
     */
    public boolean getbooleanValue(String key) {
        if (this.containsKey(key)) {
            return (boolean) (this.get(key));
        }
        return false;
    }

    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public Boolean getBooleanValue(String key) {
        if (this.containsKey(key)) {
            return (Boolean) (this.get(key));
        }
        return null;
    }
}
