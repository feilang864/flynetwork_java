/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrator
 */
class ObjectThread extends Thread {

    private int threadid;

    public ObjectThread(int id, Runnable target) {
        super(target);
        this.threadid = id;
    }

    public ObjectThread(int id, ThreadGroup group, Runnable target) {
        super(group, target);
        this.threadid = id;
    }

    public ObjectThread(int id, ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.threadid = id;
    }

    @Override
    public long getId() {
        return threadid;
    }

}
