/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine;

import com.game_engine.struct.GameRunnable;

/**
 *
 * @author Administrator
 */
public class PrintTask extends GameRunnable {
    
    public PrintTask() {
        super("测试");
    }
    
    int Count = 00;
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2);
                if (++Count >= 1) {
                    return;
                }
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
}
