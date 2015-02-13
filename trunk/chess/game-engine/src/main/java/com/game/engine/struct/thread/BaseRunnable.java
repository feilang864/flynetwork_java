package com.game.engine.struct.thread;

import com.game.engine.struct.GameAttribute;
import com.game.engine.struct.GameGlobal;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 */
public abstract class BaseRunnable implements Runnable {

    private static final Logger log = Logger.getLogger(BaseRunnable.class);

    private Long ID;
    private String Name;
    //
    private transient GameAttribute tempAttribute = new GameAttribute();

    public BaseRunnable() {
        this(GameGlobal.getInstance().getCreateId(), "");
    }

    public BaseRunnable(String Name) {
        this(GameGlobal.getInstance().getCreateId(), Name);
    }

    public BaseRunnable(long ID, String Name) {
        this.ID = ID;
        this.Name = Name;
        tempAttribute = new GameAttribute();
    }

    /**
     * 返回运行时属性值
     *
     * @return
     */
    public GameAttribute getTempAttribute() {
        return tempAttribute;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "<“" + Name + "”(" + ID + ")>";
    }

}
