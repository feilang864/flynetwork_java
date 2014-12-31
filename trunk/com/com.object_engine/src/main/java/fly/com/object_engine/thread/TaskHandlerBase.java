/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.thread;

import fly.com.object_engine.struct.ObjectBase;

/**
 *
 * @author Administrator
 */
public abstract class TaskHandlerBase extends ObjectBase {

    private static final long serialVersionUID = 8024836539616375691L;
    private int actionThreadId;

    public TaskHandlerBase() {
        this(0);
    }

    public TaskHandlerBase(int actionThreadId) {
        this(0, null);
    }

    public TaskHandlerBase(int actionThreadId, String Name) {
        super(Name == null ? "无名任务" : Name);
        this.actionThreadId = actionThreadId;
    }

    public abstract void action();

    public int getActionThreadId() {
        return actionThreadId;
    }

    public void setActionThreadId(int actionThreadId) {
        this.actionThreadId = actionThreadId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
