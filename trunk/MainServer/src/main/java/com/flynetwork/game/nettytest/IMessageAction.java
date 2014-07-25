/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

/**
 * 消息处理接口
 *
 * @author Administrator
 */
public interface IMessageAction {

    /**
     * 读取消息
     */
    void readMessage();

    /**
     * 书写消息
     */
    void writeMessage();

}
