/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.test;

import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class TestMain {

    private static final Logger log = Logger.getLogger(TestMain.class);
    private static final TestMain instance = new TestMain();

    public static TestMain getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        System.out.println("");
    }
}
