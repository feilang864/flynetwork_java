/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.routeserver;

import com.flynetwork.game.routeserver.tcpserver.IOServer;
import org.apache.log4j.Logger;

/**
 * 网关服务器
 *
 * @author Administrator
 */
public class ServerMain {
    
    protected static Logger logger = Logger.getLogger(ServerMain.class);
    
    public static void main(String[] args) {
        IOServer ioserver = new IOServer();
        ioserver.Start(9527);
        logger.info("网关服务器 启动完成");
    }
}
