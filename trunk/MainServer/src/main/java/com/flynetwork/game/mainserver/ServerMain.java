/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.mainserver;

import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author Administrator
 */
public class ServerMain extends BaseClass {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {

        MyClassLoader loader = new MyClassLoader("D:\\script\\", "D:\\script\\classes\\");
        loader.loadJava("WhichClassLoader3.java", "com.fykj.xml.main.WhichClassLoader3").newInstance();
        loader.loadJava("", "com.fykj.xml.main.WhichClassLoader2").newInstance();
        loader.loadClass("com.fykj.xml.main.WhichClassLoader3").newInstance();
        
    }

    public ServerMain() {
        super(ServerMain.class.getName());
    }
}
