/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.mainserver;

/**
 * 守护服务器
 *
 * @author Administrator
 */
public class ServerMain extends BaseClass {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {

        MyClassLoader loader = new MyClassLoader("D:\\script\\", "D:\\script\\classes\\");
        loader.loadJava("WhichClassLoader3.java", "com.fykj.xml.main.WhichClassLoader3").newInstance();
        NewInterface w2 = (NewInterface) loader.loadJava("", "com.fykj.xml.main.WhichClassLoader2").newInstance();
        w2.PutString();
        loader.loadClass("com.fykj.xml.main.WhichClassLoader3").newInstance();
        
    }

    public ServerMain() {
        super(ServerMain.class.getName());
    }
}
