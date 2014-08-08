/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.buffer;

import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public abstract class BaseNettyMessage implements IMessage {

    private int messageID;

    public BaseNettyMessage(int messageID) {
        this.messageID = messageID;
    }

    public BaseNettyMessage() {
    }

    /**
     * 获取消息ID
     *
     * @return
     */
    public int getMessageID() {
        return messageID;
    }

    /**
     * 重新tostring() 输出消息ID
     *
     * @return
     */
    @Override
    public String toString() {
        return "消息ID " + this.messageID;
    }

    @Override
    public void readMessage(ByteBufInputStream inStream) {
    }

    @Override
    public void writeMessage(ByteBufOutputStream outStream) {
        try {
            outStream.writeInt(messageID);
        } catch (IOException ex) {
            Logger.getLogger(NettyMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
