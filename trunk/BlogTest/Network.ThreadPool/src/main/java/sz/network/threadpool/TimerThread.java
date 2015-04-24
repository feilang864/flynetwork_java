/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sz.network.threadpool;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 定时器线程
 *
 * @author 失足程序员
 * @Blog http://www.cnblogs.com/ty408/
 * @mail 492794628@qq.com
 * @phone 13882122019
 */
class TimerThread extends ThreadModel {

    private static final Logger log = Logger.getLogger(TimerThread.class);

    public TimerThread() {
        super(ThreadManager.getGlobeThreadGroup(), "全局定时器线程");
        this.start();
    }

    @Override
    public void run() {
        while (ThreadManager.getInstance().isRunning()) {
            while (ThreadManager.getInstance().isRunning() && taskQueue.isEmpty()) {
                try {
                    /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                    synchronized (taskQueue) {
                        taskQueue.wait(200);
                    }
                } catch (InterruptedException ie) {
                }
            }
            ArrayList<TaskModel> taskModels;
            synchronized (taskQueue) {
                //队列不为空的情况下  取出队列定时器任务
                taskModels = new ArrayList<>(taskQueue);
            }
            if (!taskModels.isEmpty()) {
                for (TaskModel task : taskModels) {
                    TimerTask timerEvent = (TimerTask) task;
                    int execCount = timerEvent.getRunAttribute().getintValue("Execcount");
                    long lastTime = timerEvent.getRunAttribute().getlongValue("LastExecTime");
                    long nowTime = System.currentTimeMillis();
                    if (nowTime > timerEvent.getStartTime() //是否满足开始时间
                            && (nowTime - timerEvent.getSubmitTime() > timerEvent.getIntervalTime())//提交以后是否满足了间隔时间
                            && (timerEvent.getEndTime() <= 0 || nowTime < timerEvent.getEndTime()) //判断结束时间
                            && (nowTime - lastTime >= timerEvent.getIntervalTime())) //判断上次执行到目前是否满足间隔时间
                    {
                        //提交执行
                        ThreadManager.getInstance().addTask(timerEvent.gettID(), timerEvent);
                        //记录
                        execCount++;
                        timerEvent.getRunAttribute().put("Execcount", execCount);
                        timerEvent.getRunAttribute().put("LastExecTime", nowTime);
                    }
                    nowTime = System.currentTimeMillis();
                    //判断删除条件
                    if ((timerEvent.getEndTime() > 0 && nowTime < timerEvent.getEndTime())
                            || (timerEvent.getActionCount() > 0 && timerEvent.getActionCount() <= execCount)) {
                        taskQueue.remove(task);
                    }
                }
            }
            try {
                //定时器， 执行方式 间隔 4ms 执行一次 把需要处理的任务放到对应的处理线程
                Thread.sleep(4);
            } catch (InterruptedException ex) {
            }
        }
        log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
    }

    @Override
    public void addTask(TaskModel task) {
        if (((TimerTask) task).isIsStartAction()) {
            try {
                task.run();
            } catch (Exception e) {
                log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + task.getID() + "(“" + task.getName() + "”)> 遇到错误: " + e);
                e.printStackTrace();
            }
        }
        super.addTask(task);
    }
}
