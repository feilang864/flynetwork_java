/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.mygameserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class GameServerMain {

    public static void main(String[] args) {

        try {
            ServerHelper.Init();
        } catch (IOException ex) {
            Logger.getLogger(GameServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 记录debug级别的信息
        ServerHelper.logger.debug("这是Debug信息.");
        // 记录info级别的信息
        ServerHelper.logger.info("This is info message.");
        // 记录error级别的信息
        ServerHelper.logger.error("This is error message.");

    }
}
