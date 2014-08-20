/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import org.game.game_engine.threadmodel.BaseTask;

/**
 *
 * @author Administrator
 */
public class PrintTask extends BaseTask {

    int Count = 00;

    @Override
    public void run() {
        while (true) {

            System.out.println("w s " + System.currentTimeMillis());
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
            if (++Count > 20) {
                return;
            }
        }

    }

    @Override
    public String info() {
        return "打印日志测试任务";
    }

}
