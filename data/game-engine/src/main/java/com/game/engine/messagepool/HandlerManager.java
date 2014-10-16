/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.messagepool;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fly_ty
 */
public class HandlerManager {

    private static HandlerManager instance = new HandlerManager();

    public static HandlerManager getInstance() {
        return instance;
    }

    public HandlerManager() {
        handlerMap = new HashMap<>();
    }

    Map<Long, HandlerInfo> handlerMap;

    public void registerHandlerMessage(long messageId, long threadID, Class<? extends ActionMessageHandler> handel, Class<? extends com.google.protobuf.Message> message) {
        handlerMap.put(messageId, new HandlerInfo(messageId, threadID, handel, message));
    }

    public HandlerInfo getHandlerInfo(long messageId) {
        if (handlerMap.containsKey(messageId)) {
            return handlerMap.get(messageId);
        }
        return null;
    }

}
