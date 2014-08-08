/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.main;

import java.util.concurrent.CountDownLatch;
import org.game.game_engine.threadtools.BaseTask;

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
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            if (++Count > 2) {
                return;
            }
        }

    }

    @Override
    protected boolean needExecuteImmediate() {
        return false;
    }

    @Override
    public String info() {
        return "打印日志测试任务";
    }

}
