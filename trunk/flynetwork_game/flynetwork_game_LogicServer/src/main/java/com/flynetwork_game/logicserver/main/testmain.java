/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.logicserver.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class testmain implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new testmain());
        thread.start();
        thread = new Thread(new testmain());
        thread.start();
        thread = new Thread(new testmain());
        thread.start();
        try {
            int intiI = System.in.read();
        } catch (IOException ex) {

        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException ex) {

        }
        System.out.println("ssssssss");
    }
}
