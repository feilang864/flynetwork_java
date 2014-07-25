/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import javafx.beans.property.ReadOnlyBooleanProperty;

/**
 *
 * @author Administrator
 */
public class TipsMessage extends BaseMessage implements IMessageAction {

    private static final int messageID = 900999;

    public TipsMessage() {
        super(messageID);
    }

    String tipsString;

    public TipsMessage(String tips) {
        this();
        this.tipsString = tips;
    }

    @Override
    public void writeMessage() {
        super.writeMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readMessage() {
        super.readMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + " tipsString:" + tipsString; //To change body of generated methods, choose Tools | Templates.
    }

}
