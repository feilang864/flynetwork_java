/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fykj.mymina.myconst;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * 静态辅助类
 *
 * @author Troy
 */
public class ConstHelper {

    private static Logger log = Logger.getLogger(ConstHelper.class.getName());

    /**
     * 增加打印日志
     *
     * @param msg 输出日志
     */
    public static void AddLoggerInfo(String msg) {
        //System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms").format(new Date()) + " -> " + msg);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms ").format(new Date()) + " -> " + msg);    }
}
