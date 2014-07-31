/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.tcpclient;

import com.flynetwork_game.engine.netty.NettyClient;
import org.apache.log4j.Logger;

/**
 * logic to login server tcp
 *
 * @author Troy.Chen
 */
public class LLTcpClient {

    private static LLTcpClient tcpInstance;
    Logger logger = Logger.getLogger(LLTcpClient.class);

    public static LLTcpClient getInstance() {
        if (tcpInstance == null) {
            tcpInstance = new LLTcpClient();
        }
        return tcpInstance;
    }

    NettyClient ns;

    private LLTcpClient() {
        logger.debug("向登录服务器注册");
        ns = new NettyClient(new LLTcpClientHandler());
        ns.setPort(9527);
        ns.start();
    }

    public void reConnect() {
        if (ns != null) {
            try {
                logger.debug("等待 10秒 重新连接登录服务器");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            ns.reConnect();
        }
    }

}
