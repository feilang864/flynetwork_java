/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.messagepool;

import com.game.engine.struct.GameAttribute;
import com.google.protobuf.Message;

/**
 *
 * @author fly_ty
 */
public abstract class ActionMessageHandler {

    private com.google.protobuf.Message message;
    private GameAttribute parameter;
    public static final String SESION_Value = "SESION";

    public Message getMessage() {
        return message;
    }

    public GameAttribute getParameter() {
        return parameter;
    }

    public void setParameter(GameAttribute parameter) {
        this.parameter = parameter;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public abstract void action();
}
