/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.threadtools;

/**
 *
 * 线程管理器
 *
 * @author Troy.Chen
 * @phone 13882122019
 *
 */
public class ThreadManager {

    private static ThreadManager instanceManager;

    /**
     * 返回 ThreadManager 的实例
     *
     * @return
     */
    public static ThreadManager getInstance() {

        if (instanceManager == null) {
            synchronized (ThreadManager.class) {
                if (instanceManager == null) {
                    instanceManager = new ThreadManager();
                }
            }
        }
        return instanceManager;
    }

    public ThreadManager() {
        ThreadPool.setWorker_num(2);
    }

    public void addLongTimeTask(BaseTask task) {
        ThreadPool.getInstance().addTask(task);
    }

    public void addShortTimeTask(BaseTask task) {
        ThreadPool.getInstance().addTask(task);
    }

    /**
     * 添加释放状态，提示程序退出，表示任务必须结算了
     */
    public void destroy() {
        ThreadPool.getInstance().destroy();
    }
}
