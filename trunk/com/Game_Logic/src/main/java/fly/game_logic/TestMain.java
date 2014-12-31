/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic;

import fly.com.object_engine.nio.netty.NettyTcpServer;
import fly.com.object_engine.struct.CreateHandler;
import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.ThreadManager;
import fly.com.object_engine.thread.TimeTaskHandlerBase;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 *
 * @author Administrator
 */
public class TestMain {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestMain.class);

    public static void main(String[] args) {
        try {
            new CreateHandler().execute();
        } catch (MojoExecutionException | MojoFailureException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        NettyTcpServer nettyTcpServer = new NettyTcpServer(new RecvMessagePool(), 9527);
        nettyTcpServer.start();

        ThreadGroup mapThreadGroup = new ThreadGroup(ObjectConfig.getThreadGroup(), "地图线程");
        MapMainRunnable mapMainThread = new MapMainRunnable();
        ThreadManager.getInstance();
        int threadId = ThreadManager.getInstance().getThread(mapThreadGroup, mapMainThread, "新手村");

        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), false, 2, 1000, threadId, "执行次数定时器") {
            private static final long serialVersionUID = -4078196804052284070L;

            @Override
            public void action() {
                logger.error("执行次数定时器");
            }
        });

        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), false, 2000, "无限执行") {
            private static final long serialVersionUID = -4078196804052284070L;

            @Override
            public void action() {
                logger.error("无限执行");
            }
        });

        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), true, System.currentTimeMillis() + 2 * 1000, 100, "结束时间定时器") {
            private static final long serialVersionUID = -4078196804052284070L;

            @Override
            public void action() {
                logger.error("结束时间定时器");
            }
        });

        logger.error("dddd");
    }
}
