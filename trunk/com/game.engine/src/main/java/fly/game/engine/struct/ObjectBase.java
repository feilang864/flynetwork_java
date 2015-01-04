/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.struct;

import java.io.Serializable;

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
    private transient ObjectAttribute tempObjectAttribute = new ObjectAttribute();

    public ObjectBase() {
        this.ID = ObjectConfig.getId();
    }

    public ObjectBase(String Name) {
        this();
        this.Name = Name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ObjectAttribute getTempObjectAttribute() {
        return tempObjectAttribute;
    }

    public void setTempObjectAttribute(ObjectAttribute tempObjectAttribute) {
        this.tempObjectAttribute = tempObjectAttribute;
    }

    @Override
    public String toString() {
        return "" + "ID=" + ID + ", Name=" + Name + ", 零时数据=" + tempObjectAttribute.toString();
    }

}
