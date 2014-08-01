/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.tcpclient;

import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class ReConnectScript implements Runnable {

    Thread thread;
    Logger logger = Logger.getLogger(ReConnectScript.class);

    public ReConnectScript() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            logger.debug("等待 200 ms 重新连接登录服务器");
            Thread.sleep(200);
        } catch (InterruptedException ex) {
        }
        LLTcpClient.getInstance().reConnect();
    }

}
