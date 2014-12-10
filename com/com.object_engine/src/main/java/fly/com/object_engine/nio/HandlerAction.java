/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import com.google.protobuf.Message;

/**
 *
 * @author fly_ty
 */
public abstract class HandlerAction {

    private com.google.protobuf.Message message;
    private Object parameter;

    public Message getMessage() {
        return message;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setTCPHandler(Message message, Object parameter) {
        this.message = message;
        this.parameter = parameter;
    }

    public abstract void action();
}
