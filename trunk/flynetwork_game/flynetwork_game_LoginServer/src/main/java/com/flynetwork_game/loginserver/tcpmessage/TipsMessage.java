/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.tcpmessage;

import com.flynetwork_game.engine.buffer.NettyMessage;
import com.flynetwork_game.engine.buffer.IMessage;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TipsMessage extends NettyMessage implements IMessage {

    public static final int messageID = 900999;

    public TipsMessage() {
        super(messageID);
    }

    String tipsString;

    public TipsMessage(String tips) {
        this();
        this.tipsString = tips;
    }

    @Override
    public void writeMessage(ByteBufOutputStream outStream) {
        super.writeMessage(outStream); //To change body of generated methods, choose Tools | Templates.
        try {
            outStream.writeUTF(tipsString);
        } catch (IOException ex) {
            Logger.getLogger(TipsMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void readMessage(ByteBufInputStream inStream) {
        super.readMessage(inStream); //To change body of generated methods, choose Tools | Templates.
        try {
            this.tipsString = inStream.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(TipsMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " tipsString:" + tipsString; //To change body of generated methods, choose Tools | Templates.
    }

}
