/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.test;

import com.game.engine.struct.thread.DataRunnable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class NewClass {

    private static final Object obj = new Object();
    private static int id = 0;
    public static int serverID = 0;

    public static long getId() {
        synchronized (obj) {
            id += 1;
            return (serverID & 0xFFFF) << 48 | (System.currentTimeMillis() / 1000L & 0xFFFFFFFF) << 16 | id & 0xFFFF;
        }
    }
    private static final SimpleDateFormat DF2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS: ");

    public static String getDateFormat1() {
        return DF2.format(new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new NewClass();
        }
    }

    public NewClass() throws InterruptedException {
        Thread thread = new Thread(new ThreadRun());
        thread.start();
        thread.join();
    }

    private final HashMap<Object, Object> Objects = new HashMap<>();

    class ThreadRun implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("=============================");
                int i = 5;
                while (--i > 0) {
                    System.out.println(getDateFormat1() + "Start");
                    Thread.sleep(1);
//                    synchronized (Objects) {
//                        Objects.wait(10);
//                    }
                    System.out.println(getDateFormat1() + "End");
                }
            } catch (InterruptedException ex) {
            }
        }
    }

//    public static void main(String[] args) throws Exception {
//        for (int j = 0; j < 5; j++) {
//            serverID = j;
//            id = 0;
//            HashSet<String> ids = new HashSet<>(0);
//            System.out.println(getDateFormat1() + "开始测试：" + j);
//            int forCount = 600 * 10000;
//            for (int i = 0; i < forCount; i++) {
//                //long tempid = getId();
//                String tempid = UUID.randomUUID().toString();
//                boolean add = ids.add(tempid);
//                if (!add) {
//                    System.out.println(getDateFormat1() + "重复: " + i + "    " + tempid);
//                }
//            }
//            System.out.println(getDateFormat1() + " 结束测试：" + j + " 执行次数：" + forCount);
//        }
//    }
}
