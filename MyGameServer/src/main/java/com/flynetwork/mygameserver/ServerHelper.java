/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.mygameserver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 增加打印日志
     *
     * @param msg 输出日志
     */
    public static void AddLoggerInfo(String msg) {
        logger.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms ").format(new Date()) + " -> " + msg);
    }
}
