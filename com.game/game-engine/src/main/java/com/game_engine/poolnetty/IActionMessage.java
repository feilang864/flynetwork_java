/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.poolnetty;

/**
 *
 * @author Administrator
 */
public interface IActionMessage {

    /**
     * 返回消息处理器的实例
     *
     * @return
     */
    INettyHandler getNettyHandlerInstance();
}
