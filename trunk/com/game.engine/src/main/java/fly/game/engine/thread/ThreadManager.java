/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game.engine.thread;

import fly.game.engine.struct.ObjectConfig;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Administrator
 */
public class ThreadManager {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ThreadManager.class);
    private static final ThreadManager instance = new ThreadManager();
    private static int threadId = 0;

    public static ThreadManager getInstance() {
        return instance;
    }
    private Object THREADID_OBJECT = new Object();

    private RunnableBase back_RunnableBase = new RunnableBase();
    private HashMap<Integer, ObjectThread> taskThreadHashMap = new HashMap<>(0);
    private HashMap<Integer, RunnableBase> taskRunnableHashMap = new HashMap<>(0);
    private TimeRunnable time_Runnable = new TimeRunnable();

    public ThreadManager() {
        synchronized (THREADID_OBJECT) {
            ObjectThread time_Thread = new ObjectThread(++threadId, ObjectConfig.getThreadGroup(), time_Runnable, "全局定时器线程执行器");
            taskThreadHashMap.put((int) time_Thread.getId(), time_Thread);
            time_Thread.start();
            log.error("线程管理器 全局定时器线程执行器");
            ThreadGroup back_Group = new ThreadGroup(ObjectConfig.getThreadGroup(), "后台线程");
            for (int i = 0; i < 10; i++) {
                ObjectThread thread = new ObjectThread(++threadId, back_Group, back_RunnableBase, "后台线程" + i);
                taskThreadHashMap.put((int) thread.getId(), thread);
                thread.start();
                log.error("线程管理器 初始化后台线程 " + thread.getId());
            }
        }
    }

    /**
     * 添加任务
     *
     * @param task
     */
    public void addTask(TaskHandlerBase task) {
        RunnableBase thread = taskRunnableHashMap.get(task.getActionThreadId());
        if (thread != null) {
            thread.addTask(task);
        } else {
            addBackTask(task);
            log.error("未找到指定线程，放到后台处理");
        }
    }

    /**
     * 添加后台执行的 任务
     *
     * @param task
     */
    public void addBackTask(TaskHandlerBase task) {
        back_RunnableBase.addTask(task);
    }

    /**
     *
     * @param newTask
     */
    public void addTimeTask(TimeTaskHandlerBase newTask) {
        time_Runnable.addTask(newTask);
    }

    public int getThread(RunnableBase run, String threadName) {
        return this.getThread(ObjectConfig.getThreadGroup(), run, threadName);
    }

    public int getThread(RunnableBase run) {
        return this.getThread(run, "无名线程");
    }

    public int getThread(ThreadGroup threadGroup, RunnableBase run, String threadName) {
        int id = 0;
        synchronized (THREADID_OBJECT) {
            id = ++threadId;
        }
        ObjectThread thread = new ObjectThread(id, threadGroup, run, threadName);
        taskThreadHashMap.put(id, thread);
        taskRunnableHashMap.put(id, run);
        thread.start();
        return id;
    }

}
