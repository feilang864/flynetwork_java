/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.mygameserver;

import com.flynetwork.gameserver.tcpserver.MinaServer;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class GameServerMain {

    public static void main(String[] args) {
        try {
            ServerHelper.Init();
        } catch (IOException ex) {
            ServerHelper.logger.error(ex);
        }
        
        MinaServer mina=new MinaServer();
        mina.Start(5555);

    }
}
