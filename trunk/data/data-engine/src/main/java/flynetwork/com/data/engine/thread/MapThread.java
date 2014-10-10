/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.thread;

import flynetwork.com.data.engine.manager.GlobalManager;
import flynetwork.com.data.engine.manager.MapManager;
import flynetwork.com.data.engine.poolmessage.ActionMessageHandler;
import flynetwork.com.data.engine.poolmessage.MessageRunnable;
import flynetwork.com.data.engine.struct.map.IMapInfo;
import flynetwork.com.data.engine.struct.thread.DataRunnable;
import flynetwork.com.data.engine.struct.thread.TimerEventRunnable;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_ty
 */
public class MapThread extends RunnableThread {

    private static final long serialVersionUID = -8711653349963675546L;

    private static final Logger logger = Logger.getLogger(MapThread.class);

    public MapThread() {
        super(GlobalManager.getInstance().getGlobeThreadGroup(), "地图执行器");
    }

    @Override
    public void run() {
        while (GlobalManager.getInstance().isRunning()) {
            DataRunnable runnable = null;
            synchronized (taskQueue) {
                while (GlobalManager.getInstance().isRunning() && taskQueue.isEmpty()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(200);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
                if (GlobalManager.getInstance().isRunning()) {
                    //队列不为空的情况下  取出队列定时器任务
                    runnable = taskQueue.remove(0);
                }
            }
            long threadid = 0;
            if (runnable instanceof MessageRunnable) {
                MessageRunnable messageRunnable = (MessageRunnable) runnable;
                IMapInfo parameter = (IMapInfo) messageRunnable.getMsgHandler().getParameter(ActionMessageHandler.IMapInfo_StringValue);
                MapManager.getInstance().addMessage(parameter, runnable);
            } else if (runnable instanceof TimerEventRunnable) {
                TimerEventRunnable timerEventRunnable = (TimerEventRunnable) runnable;
                MapManager.getInstance().addMessage(timerEventRunnable, runnable);
            }
        }
        logger.error("线程结束, 工人<“" + this.getName() + "”>退出");
    }
}
