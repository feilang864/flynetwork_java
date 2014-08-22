/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import org.game.game_engine.struct.BaseTask;
import org.game.game_engine.struct.GameRunnable;

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

            //System.out.println("w s " + System.currentTimeMillis());
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
            if (++Count >= 1) {
                return;
            }
        }
    }

}
