/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.poolmessage;

import com.google.protobuf.Message;
import flynetwork.com.data.engine.struct.GameAttribute;

/**
 *
 * @author fly_ty
 */
public abstract class ActionMessageHandler {

    private com.google.protobuf.Message message;
    private GameAttribute parameter;

    public static final String PLAYER_StringValue = "PLAYER";

    public static final String SESION_StringValue = "SESION";

    public static final String IMapInfo_StringValue = "IMapInfo";

    public Message getMessage() {
        return message;
    }

    public void setParameter(String key, Object value) {
        parameter.setValue(key, value);
    }

    public Object getParameter(String key) {
        return parameter.getValue(key);
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public abstract void action();
}
