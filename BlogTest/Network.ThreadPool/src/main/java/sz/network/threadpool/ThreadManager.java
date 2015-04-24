package sz.network.threadpool;

import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 * 线程管理器
 *
 * @author 失足程序员
 * @Blog http://www.cnblogs.com/ty408/
 * @mail 492794628@qq.com
 * @phone 13882122019
 *
 */
public class ThreadManager {

    private static final Logger log = Logger.getLogger(ThreadManager.class);

    private static final ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");
    private static final ThreadGroup lsThreadGroup = new ThreadGroup("零时线程");

    private static ThreadManager instance = new ThreadManager();

    private static final HashMap<Long, ThreadModel> workThreadMaps = new HashMap<>(0);

    public static ThreadManager getInstance() {
        return instance;
    }

    public static ThreadGroup getGlobeThreadGroup() {
        return GlobeThreadGroup;
    }

    private final BackThread backThread = new BackThread();

    private final TimerThread timerThread = new TimerThread();

    //服务器是否运行状态标识
    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void StopServer() {
        running = false;
    }

    public long addThread(ThreadModel thread) {
        workThreadMaps.put(thread.getId(), thread);
        thread.start();
        return thread.getId();
    }

    public long getThread(ThreadGroup threadGroup, String workName) {
        return addThread(new ThreadModel(threadGroup, workName));
    }

    public long getThread(String workName) {
        return addThread(new ThreadModel(lsThreadGroup, workName));
    }

    public boolean delete(long threadID) {
        ThreadModel get = workThreadMaps.remove(threadID);
        if (get != null) {
            get.setRuning(false);
            return true;
        }
        return false;
    }

    public void addTask(long threadID, TaskModel task) {
        if (workThreadMaps.containsKey(threadID)) {
            workThreadMaps.get(threadID).addTask(task);
        } else {
            addBackTask(task);
        }
    }

    public void addTimerTask(TimerTask task) {
        timerThread.addTask(task);
    }

    /**
     *
     * @param task
     */
    public void addBackTask(TaskModel task) {
        backThread.addTask(task);
    }

}
