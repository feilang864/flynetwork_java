/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.tcpserver;

import com.flynetwork_game.engine.buffer.BaseMessage;
import com.flynetwork_game.engine.buffer.IActionMessage;
import com.flynetwork_game.loginserver.tcpmessage.TipsMessage;
import io.netty.buffer.ByteBufInputStream;

/**
 *
 * @author Administrator
 */
public class ActionMessageHandler implements IActionMessage {

    @Override
    public BaseMessage action(int megID, ByteBufInputStream bbis) {
        switch (TipsMessage.messageID) {
            case 9009:
                TipsMessage tipsMessage = new TipsMessage();
                tipsMessage.readMessage(bbis);
                return tipsMessage;
        }
        return null;
    }

}
