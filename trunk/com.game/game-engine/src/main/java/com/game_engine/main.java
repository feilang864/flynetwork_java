/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine;

import com.game_engine.poolmessage.MessageBean;
import com.game_engine.poolmina.MinaTcpClient;
import com.game_engine.poolmina.MinaTcpServer;
import com.game_engine.poolnetty.NettyTcpClient;
import com.game_engine.poolnetty.NettyTcpServer;
import com.game_engine.utils.MapUtil;
import com.game_engine.utils.ThreadUtil;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) throws InterruptedException {
        //ThreadUtil.init(5);
        NettyTcpServer nettyTcpServer = new NettyTcpServer();
//        nettyTcpServer.start();
        NettyTcpClient nettyTcpClient = new NettyTcpClient();
        nettyTcpClient.start();
        MessageBean bean = new MessageBean(1000021);
        bean.setMsgbuffer(new byte[5]);
        Thread.sleep(2000);
        nettyTcpClient.sendMsg(bean);
        Thread.sleep(2000);
        System.exit(0);
//        MinaTcpServer minaTcpServer = new MinaTcpServer();
//        if (!minaTcpServer.Start(9527)) {
//            System.exit(0);
//        }
//
//        MinaTcpClient clent = new MinaTcpClient();
//        for (int i = 0; i < 1; i++) {
//            System.err.println(i);
//            clent.sendMessage("Hello World " + i);
//        }
        //clent.getSocketConnector().dispose();
    }
}
