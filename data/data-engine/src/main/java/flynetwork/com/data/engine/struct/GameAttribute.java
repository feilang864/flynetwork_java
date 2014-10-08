/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.struct;

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

    Map<String, Object> attributesMap;

    public GameAttribute() {
        attributesMap = new HashMap<>();
    }

    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public Object getValue(String key) {
        if (attributesMap.containsKey(key)) {
            return attributesMap.get(key);
        }
        return null;
    }

    /**
     *
     * @param key
     * @param attribute
     */
    public void setValue(String key, Object attribute) {
        this.attributesMap.put(key, attribute);
    }

    /**
     * 如果未找到也返回 null
     *
     * @param key
     * @return
     */
    public String getStringValue(String key) {
        if (attributesMap.containsKey(key)) {
            return attributesMap.get(key).toString();
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
        if (attributesMap.containsKey(key)) {
            return (int) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (Integer) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (long) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (Long) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (float) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (Float) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (boolean) (attributesMap.get(key));
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
        if (attributesMap.containsKey(key)) {
            return (Boolean) (attributesMap.get(key));
        }
        return null;
    }
}
