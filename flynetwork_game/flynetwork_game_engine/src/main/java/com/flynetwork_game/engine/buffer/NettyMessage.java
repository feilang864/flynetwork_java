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
 * 根消息
 *
 * @author Administrator
 */
public class NettyMessage {

    private int messageID;
    private ByteBufInputStream megBuffers;

    public NettyMessage(int messageID, ByteBufInputStream megBuffers) {
        this.messageID = messageID;
        this.megBuffers = megBuffers;
    }

    public int getMessageID() {
        return messageID;
    }

    public ByteBufInputStream getMegBuffers() {
        return megBuffers;
    }
}
