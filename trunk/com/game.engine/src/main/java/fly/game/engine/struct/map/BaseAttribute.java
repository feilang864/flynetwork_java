package fly.game.engine.struct.map;

import fly.game.engine.struct.ObjectAttribute;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础属性结果
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public class BaseAttribute implements Serializable {

    private static final long serialVersionUID = 7331996190994084714L;
    private static final int MAX_PROBABILITY = 10000;
    private ObjectAttribute attributeMap = new ObjectAttribute();

    public BaseAttribute() {
    }

    public ObjectAttribute getAttributeMap() {
        return attributeMap;
    }

    public void setAttributeMap(ObjectAttribute attributeMap) {
        this.attributeMap = attributeMap;
    }

    /**
     * 属性清零
     *
     */
    public void clearZero() {
        for (Map.Entry<String, Object> entrySet : attributeMap.entrySet()) {
            String key = entrySet.getKey();
            attributeMap.put(key, 0);
        }
    }

    /**
     * 属性小于0的处理
     */
    public void zeroAbility() {
        for (Map.Entry<String, Object> entrySet : attributeMap.entrySet()) {
            String key = entrySet.getKey();
            int intValue = attributeMap.getIntValue(key);
            if (intValue < 0) {
                intValue = 0;
                attributeMap.put(key, intValue);
            }
        }
    }
}
