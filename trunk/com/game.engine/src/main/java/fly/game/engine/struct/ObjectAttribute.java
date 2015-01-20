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
public class ObjectAttribute extends HashMap<String, Object> {

    private static final long serialVersionUID = -6282823840742731975L;

    public ObjectAttribute() {
    }

    /**
     * 调用此方法 删除值是需要保证存在key值和value值 否则空指针报错
     *
     * @param <T>
     * @param key
     * @param clazz
     * @return
     * @deprecated 需要保证存在key值和value值 否则空指针报错 慎重
     */
    @Deprecated
    public <T extends Object> T remove(String key, Class<T> clazz) {
        Object remove = this.remove(key);
        return (T) remove;
    }

    /**
     * 未找到为 null
     *
     * @param key
     * @return
     */
    public Integer getIntegerValue(String key) {
        if (super.containsKey(key)) {
            return (Integer) (super.get(key));
        }
        return null;
    }

    /**
     * 未找到为0
     *
     * @param key
     * @return
     */
    public int getIntValue(String key) {
        if (super.containsKey(key)) {
            return (int) (super.get(key));
        }
        return 0;
    }

    /**
     * 未找到为 null
     *
     * @param key
     * @return
     */
    public String getStringValue(String key) {
        if (super.containsKey(key)) {
            return super.get(key).toString();
        }
        return null;
    }

    /**
     * 未找到为 null
     *
     * @param key
     * @return
     */
    public Long getLongValue(String key) {
        if (super.containsKey(key)) {
            return (Long) (super.get(key));
        }
        return null;
    }

    /**
     * 未找到返回0
     *
     * @param key
     * @return
     */
    public long getlongValue(String key) {
        if (super.containsKey(key)) {
            return (long) (super.get(key));
        }
        return 0;
    }

    /**
     * 未找到返回0
     *
     * @param key
     * @return
     */
    public Double getDoubleValue(String key) {
        if (super.containsKey(key)) {
            return (Double) (super.get(key));
        }
        return null;
    }

    /**
     * 未找到返回0
     *
     * @param key
     * @return
     */
    public double getdoubleValue(String key) {
        if (super.containsKey(key)) {
            return (double) (super.get(key));
        }
        return 0.0;
    }

    /**
     * 未找到为 null
     *
     * @param key
     * @return
     */
    public Float getFloatValue(String key) {
        if (super.containsKey(key)) {
            return (Float) (super.get(key));
        }
        return null;
    }

    /**
     * 未找到返回0
     *
     * @param key
     * @return
     */
    public float getfloatValue(String key) {
        if (super.containsKey(key)) {
            return (float) (super.get(key));
        }
        return 0;
    }

    /**
     * 未找到返回 null
     *
     * @param key
     * @return
     */
    public Boolean getBooleanValue(String key) {
        if (super.containsKey(key)) {
            return (Boolean) (super.get(key));
        }
        return null;
    }

    /**
     * 未找到返回 false
     *
     * @param key
     * @return
     */
    public boolean getbooleanValue(String key) {
        if (super.containsKey(key)) {
            return (boolean) (super.get(key));
        }
        return false;
    }

    @Override
    public Object clone() {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
