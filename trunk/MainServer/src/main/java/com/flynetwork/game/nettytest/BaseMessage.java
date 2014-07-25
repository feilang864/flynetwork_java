/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

/**
 * 根消息
 *
 * @author Administrator
 */
public class BaseMessage implements IMessageAction {

    private int messageID;

    public BaseMessage(int messageID) {
        this.messageID = messageID;
    }

    public BaseMessage() {
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
    public void readMessage() {

    }

    /**
     * 获取消息体，Message对象转化成字节数组
     *
     * @return
     */
    @Override
    public void writeMessage() {

    }

}
