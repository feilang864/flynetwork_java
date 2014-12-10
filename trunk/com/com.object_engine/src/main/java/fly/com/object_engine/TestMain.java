/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine;

import fly.com.object_engine.thread.TaskHandlerBase;
import fly.com.object_engine.thread.TaskThread;
import fly.com.object_engine.thread.ThreadManager;
import fly.com.object_engine.thread.TimeTaskHandlerBase;

/**
 *
 * @author Administrator
 */
public class TestMain {

    public static void main(String[] args) {

        ThreadManager.getInstance().addBackTask(new TaskHandlerBase() {

            @Override
            public void action() {
                System.out.println("dddd");
            }
        });

        ThreadManager.getInstance().addBackTask(new TaskHandlerBase() {

            @Override
            public void action() {
                System.out.println("dddd");
            }
        });

        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), true, 10, 1000) {
            @Override
            public void action() {
                System.out.println("TimeTask");
            }
        });

        System.out.println("dddd");
    }
}
