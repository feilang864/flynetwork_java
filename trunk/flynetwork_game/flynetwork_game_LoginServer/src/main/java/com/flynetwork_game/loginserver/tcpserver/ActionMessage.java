/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.loginserver.tcpserver;

import com.flynetwork_game.engine.buffer.NettyMessage;
import com.flynetwork_game.engine.buffer.IActionMessage;
import com.flynetwork_game.engine.buffer.INettyHandler;
import com.flynetwork_game.loginserver.tcpmessage.TipsMessage;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *
 * @author Administrator
 */
public class ActionMessage implements IActionMessage {

    @Override
    public INettyHandler getNettyHandlerInstance() {
        return new TcpHandler();
    }

}
