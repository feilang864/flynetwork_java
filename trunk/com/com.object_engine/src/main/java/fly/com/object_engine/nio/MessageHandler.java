/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import com.google.protobuf.Message;

/**
 *
 * @author Administrator
 */
public abstract class MessageHandler {

    public abstract void action(Message message);
}