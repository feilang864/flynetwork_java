package sz.network.threadpool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 线程模型
 *
 * @author 失足程序员
 * @Blog http://www.cnblogs.com/ty408/
 * @mail 492794628@qq.com
 * @phone 13882122019
 *
 */
public class ThreadModel extends Thread {

    private static final Logger log = Logger.getLogger(TaskModel.class);
    private static int threadID = 0;
    private static final Object SYN_OBJECT = new Object();
    private long tid;
    /**
     * 任务列表 线程安全的任务列表
     */
    protected final List<TaskModel> taskQueue = Collections.synchronizedList(new LinkedList<TaskModel>());
    //false标识删除线程
    private boolean runing = true;

    public ThreadModel(ThreadGroup group) {
        this(group, "无名");
    }

    public ThreadModel(ThreadGroup group, String name) {
        super(group, name);
        synchronized (SYN_OBJECT) {
            threadID++;
            tid = threadID;
        }
    }

    @Override
    public long getId() {
        return this.tid;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param runnable
     */
    public void addTask(TaskModel runnable) {
        synchronized (taskQueue) {
            taskQueue.add(runnable);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
    }

    public void setRuning(boolean runing) {
        this.runing = runing;
    }

    @Override
    public void run() {
        while (runing && ThreadManager.getInstance().isRunning()) {
            TaskModel r = null;
            while (taskQueue.isEmpty() && runing && ThreadManager.getInstance().isRunning()) {
                try {
                    /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                    synchronized (taskQueue) {
                        taskQueue.wait(500);
                    }
                } catch (InterruptedException ie) {
                    log.error(ie);
                }
            }
            synchronized (taskQueue) {
                /* 取出任务执行 */
                if (runing && ThreadManager.getInstance().isRunning()) {
                    r = taskQueue.remove(0);
                }
            }
            if (r != null) {
                /* 执行任务 */
                //r.setSubmitTimeL();
                long submitTime = System.currentTimeMillis();
                try {
                    r.run();
                } catch (Exception e) {
                    log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + r.getID() + "(“" + r.getName() + "”)> 遇到错误: " + e);
                    e.printStackTrace();
                }
                long timeL1 = System.currentTimeMillis() - submitTime;
                long timeL2 = System.currentTimeMillis() - r.getSubmitTime();
                if (timeL1 <= 100L) {
                    log.info("工人<“" + Thread.currentThread().getName() + "”> 完成了任务：" + r.toString() + " 执行耗时：" + timeL1 + " 提交耗时：" + timeL2);
                } else if (timeL1 <= 1000L) {
                    log.info("工人<“" + Thread.currentThread().getName() + "”> 长时间执行 完成任务：" + r.toString() + " “考虑”任务脚本逻辑 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                } else if (timeL1 <= 4000L) {
                    log.info("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “检查”任务脚本逻辑 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                } else {
                    log.info("工人<“" + Thread.currentThread().getName() + "”> 超长时间执行完成 任务：" + r.toString() + " “考虑是否应该删除”任务脚本 耗时：" + timeL1 + " 提交耗时：" + timeL2);
                }
                r = null;
            }
        }
        log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
    }

    @Override
    public String toString() {
        return "Thread{" + "tid=" + tid + ",Name=" + this.getName() + '}';
    }

}
