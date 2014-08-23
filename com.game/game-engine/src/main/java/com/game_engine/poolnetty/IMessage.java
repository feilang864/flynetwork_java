/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;

/**
 * 消息处理接口
 *
 * @author Administrator
 */
public interface IMessage {

    /**
     * 读取消息
     * @param inStream
     */
    void readMessage(ByteBufInputStream inStream);

    /**
     * 书写消息
     * @param outStream
     */
    void writeMessage(ByteBufOutputStream outStream);

}
