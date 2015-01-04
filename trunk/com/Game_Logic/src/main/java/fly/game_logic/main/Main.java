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

        RECV_MESSAGE_POOL.registerHandlerMessage(RegisterLogicMessage.Protos_Register.ReqRegisterLogic_VALUE, RegisterLogicMessage.ReqRegisterLogicMessage.class, ReqRegisterLogicHandler.class, threadId);
        NettyTcpServer nettyTcpServer = new NettyTcpServer(RECV_MESSAGE_POOL, 9527);
        nettyTcpServer.start();

        logger.error("dddd");
    }
}
