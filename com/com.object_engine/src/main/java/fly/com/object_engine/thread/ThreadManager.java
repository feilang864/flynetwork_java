/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.thread;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class ThreadManager {

    private static final ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance() {
        return instance;
    }

    private BackTaskThread backTaskThread = new BackTaskThread("后台线程", 10);
    private TimeTaskThread timeTaskThread = new TimeTaskThread();
    private HashMap<Integer, TaskThread> taskHashMap = new HashMap<>(0);

    public ThreadManager() {
    }

    /**
     *
     * @param threadId
     * @param task
     */
    public void addTask(TaskHandlerBase task) {
        TaskThread thread = taskHashMap.get(task.getActionThreadId());
        if (thread != null) {
            thread.addTask(task);
        } else {
            addBackTask(task);
        }
    }

    /**
     *
     * @param task
     */
    public void addBackTask(TaskHandlerBase task) {
        backTaskThread.addTask(task);
    }

    /**
     *
     * @param newTask
     */
    public void addTimeTask(TimeTaskHandlerBase newTask) {
        timeTaskThread.addTask(newTask);
    }

    /**
     *
     * @param threadGroup
     * @param threadName
     * @return
     */
    public int getActionThread(ThreadGroup threadGroup, String threadName) {
        TaskThread taskThread = new TaskThread(threadGroup, threadName);
        taskHashMap.put(taskThread.getId(), taskThread);
        return taskThread.getId();
    }

    /**
     *
     * @param threadName
     * @return
     */
    public int getActionThread(String threadName) {
        TaskThread taskThread = new TaskThread(threadName);
        taskHashMap.put(taskThread.getId(), taskThread);
        return taskThread.getId();
    }

    /**
     *
     * @param taskThread
     * @return
     */
    public int addActionThread(TaskThread taskThread) {
        taskHashMap.put(taskThread.getId(), taskThread);
        return taskThread.getId();
    }
}
