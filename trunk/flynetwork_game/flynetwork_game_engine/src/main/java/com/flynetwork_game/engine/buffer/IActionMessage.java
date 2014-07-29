/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flynetwork_game.engine.buffer;

import io.netty.buffer.ByteBufInputStream;

/**
 *
 * @author Administrator
 */
public interface IActionMessage {

    /**
     *
     * @param megID
     * @param bbis
     * @return
     */
    BaseMessage action(int megID,ByteBufInputStream bbis);
}
