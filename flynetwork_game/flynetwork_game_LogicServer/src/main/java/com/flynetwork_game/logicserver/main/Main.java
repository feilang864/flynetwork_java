/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.main;

import com.flynetwork_game.logicserver.tcpclient.LLTcpClient;
import com.flynetwork_game.logicserver.tcpserver.TcpServer;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LLTcpClient.getInstance();
        logger.debug("test");
    }

}
