/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.tcpserver;

import com.flynetwork_game.engine.netty.NettyServer;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class TcpServer {

    private static TcpServer tcpInstance;
    private final Logger logger = Logger.getLogger(TcpServer.class);

    public static TcpServer getInstance() {
        if (tcpInstance == null) {
            tcpInstance = new TcpServer();
        } else {
            tcpInstance.logger.debug("逻辑服务器,已经启动");
        }
        return tcpInstance;
    }

    private TcpServer() {
        logger.debug("开始启动逻辑服务器");
        NettyServer ns = new NettyServer(new ActionMessage());
        ns.setPort(9523);
        ns.start();
    }

}
