/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.struct;

import java.io.Serializable;
import java.util.Random;

/**
 * 基类
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class ObjectBase implements Serializable {

    private static final long serialVersionUID = 6613390145680665678L;

    private Long ID;
    private String Name;
    private transient ObjectAttribute gameAttribute = new ObjectAttribute();

    public ObjectBase() {
        this.ID = ObjectConfig.getId();
    }

    public ObjectBase(String Name) {
        this();
        this.Name = Name;
    }

    public ObjectAttribute getGameAttribute() {
        return gameAttribute;
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
        return "GameObject{" + "ID=" + ID + ", Name=" + Name + ", gameAttribute=" + gameAttribute + '}';
    }

}
