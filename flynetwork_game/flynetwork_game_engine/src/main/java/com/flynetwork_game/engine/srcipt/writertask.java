/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork_game.engine.srcipt;

/**
 *
 * @author Administrator
 */
public class writertask extends ScriptTaskMillisecondTimer {

    public writertask() {
        super(5);
    }

    @Override
    public void run() {
        System.out.println("writertask");
    }

}
