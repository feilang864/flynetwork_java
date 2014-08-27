/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import io.netty.buffer.ByteBufInputStream;

/**
 * 根消息
 *
 * @author Administrator
 */
public class NettyMessage1 {

    private int messageID;
    private ByteBufInputStream megBuffers;

    public NettyMessage1(int messageID, ByteBufInputStream megBuffers) {
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
