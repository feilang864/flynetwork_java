/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fykj.mymina.myconst;

/**
 *
 * @author Administrator
 */
public class MyClassLoader {

    public static void main(String[] args) {
        Class c;
        ClassLoader cl;
        cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        while (cl != null) {
            cl = cl.getParent();
            System.out.println(cl);
        }
        try {
            c = Class.forName(" java.lang.Object ");
            cl = c.getClassLoader();
            System.out.println(" java.lang.Object's loader is  " + cl);
            c = Class.forName(" MyClassLoader ");
            cl = c.getClassLoader();
            System.out.println(" MyClassLoader's loader is  " + cl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
