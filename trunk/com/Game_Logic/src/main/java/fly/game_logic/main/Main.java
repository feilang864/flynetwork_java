/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic.main;

import com.game.proto.RegisterLogicMessage;
import com.game.proto.handler.registerlogic.ReqRegisterLogicHandler;
import fly.com.object_engine.nio.netty.NettyTcpServer;
import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.ThreadManager;
import fly.com.object_engine.thread.TimeTaskHandlerBase;
import fly.game_logic.MapMainRunnable;
import fly.game_logic.io.RecvMessagePool;

/**
 *
 * @author Administrator
 */
public class Main {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Main.class);
    private static final RecvMessagePool RECV_MESSAGE_POOL = new RecvMessagePool();

    public static void main(String[] args) {
        ThreadGroup mapThreadGroup = new ThreadGroup(ObjectConfig.getThreadGroup(), "地图线程");
        MapMainRunnable mapMainThread = new MapMainRunnable();
        ThreadManager.getInstance();
        int threadId = ThreadManager.getInstance().getThread(mapThreadGroup, mapMainThread, "新手村");

        RECV_MESSAGE_POOL.registerHandlerMessage(10000L, RegisterLogicMessage.ReqRegisterLogicMessage.class, ReqRegisterLogicHandler.class, threadId);
        NettyTcpServer nettyTcpServer = new NettyTcpServer(RECV_MESSAGE_POOL, 9527);
        nettyTcpServer.start();

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
