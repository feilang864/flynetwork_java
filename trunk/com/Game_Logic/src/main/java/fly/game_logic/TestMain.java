/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic;

import fly.com.object_engine.nio.netty.NettyTcpServer;
import fly.com.object_engine.struct.GenerateHandler;
import fly.com.object_engine.thread.ThreadManager;
import fly.com.object_engine.thread.TimeTaskHandlerBase;
import java.io.File;

/**
 *
 * @author Administrator
 */
public class TestMain {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestMain.class);

    public static void main(String[] args) {
        new GenerateHandler().execute();

//        NettyTcpServer nettyTcpServer = new NettyTcpServer(new RecvMessagePool(), 9527);
//        nettyTcpServer.start();
//
//        MapMainThread mapMainThread = new MapMainThread();
//
//        ThreadManager.getInstance().addActionThread(mapMainThread);
//
//        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), true, 2, 1000, mapMainThread.getId(), "执行次数定时器") {
//            private static final long serialVersionUID = -4078196804052284070L;
//
//            @Override
//            public void action() {
//                logger.error("执行次数定时器");
//            }
//        });
//
//        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), false, 2000, "无限执行") {
//            private static final long serialVersionUID = -4078196804052284070L;
//
//            @Override
//            public void action() {
//                logger.error("无限执行");
//            }
//        });
//
//        ThreadManager.getInstance().addTimeTask(new TimeTaskHandlerBase(System.currentTimeMillis(), false, System.currentTimeMillis() + 2 * 1000, 100, "结束时间定时器") {
//            private static final long serialVersionUID = -4078196804052284070L;
//
//            @Override
//            public void action() {
//                logger.error("结束时间定时器");
//            }
//        });
//
//        logger.error("dddd");
    }
}
