/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import fly.com.object_engine.struct.ObjectAttribute;

/**
 *
 * @author Administrator
 */
public abstract class MessageHandler {

    private ObjectAttribute others = new ObjectAttribute();

    public ObjectAttribute getOthers() {
        return others;
    }

    public void setOthers(ObjectAttribute others) {
        this.others = others;
    }

    public abstract void run();

}
