/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sz.network.threadpool;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {

        long thread = ThreadManager.getInstance().getThread("Test");
        ThreadManager.getInstance().addBackTask(new TaskModel() {

            @Override
            public void run() {
                System.out.println("addBackTask");
            }
        });
        ThreadManager.getInstance().addTimerTask(new TimerTask(5, 100) {

            @Override
            public void run() {
                System.out.println("TimerTask 5 100");
            }
        });
        ThreadManager.getInstance().addTask(thread, new TaskModel() {

            @Override
            public void run() {
                System.out.println("Thread test");
            }
        });
    }
}
