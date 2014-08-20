/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.game_engine.utils;

/**
 *
 * @author Administrator
 */
public class WorkerThread extends Thread {

    private Runnable _Target;
    //自定义线程ID
    private long threadID = 1;

    private int threadGroupID = 0;

    public WorkerThread(Runnable target) {
        this._Target = target;
        this.start();
    }

    /**
     *
     * @return
     */
    public Runnable getTarget() {
        return _Target;
    }  
    

    @Override
    public void run() {
        this._Target.run();
    }

    @Override
    public String toString() {
        return "{threadID=" + threadID + ", threadGroupID=" + threadGroupID + '}';
    }

    

}
