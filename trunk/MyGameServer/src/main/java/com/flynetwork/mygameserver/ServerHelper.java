/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.mygameserver;

import com.flynetwork.gameserver.dataserver.MySqlHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrator
 */
public class ServerHelper {

    public static Logger logger;

    /**
     * 初始化 Helper
     */
    public static void Init() throws IOException {
        //PropertyConfigurator.configure("log4j.properties");     
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/conf/log4j.properties"); 
        logger = Logger.getLogger(ServerHelper.class);
    }
}
