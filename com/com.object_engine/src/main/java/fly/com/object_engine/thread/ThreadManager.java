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

    public void addTask(int threadId, TaskHandlerBase task) {
        TaskThread thread = taskHashMap.get(threadId);
        if (thread != null) {
            thread.addTask(task);
        } else {
            addBackTask(task);
        }
    }

    public void addBackTask(TaskHandlerBase task) {
        backTaskThread.addTask(task);
    }

    public void addTimeTask(TimeTaskHandlerBase newTask) {
        timeTaskThread.addTask(newTask);
    }

    public int getActionThread(String threadName) {
        TaskThread taskThread = new TaskThread(threadName);
        return taskThread.getId();
    }
}
