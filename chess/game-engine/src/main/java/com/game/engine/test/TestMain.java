/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.engine.test;

import com.game.engine.nettypool.NettyMessageHandler;
import com.game.engine.nettypool.NettyTcpServer;
import com.game.engine.nettypool.message.NettyMessageBean;
import com.game.engine.struct.thread.DataRunnable;
import com.game.engine.threadpool.ThreadManager;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class TestMain {

    private static final Logger log = Logger.getLogger(TestMain.class);
    private static final TestMain instance = new TestMain();

    public static TestMain getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        NettyTcpServer tcpServer = new NettyTcpServer(9527, new NettyMessageHandler() {

            @Override
            public void channelActive(ChannelHandlerContext session) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void readMessage(NettyMessageBean msg) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void closeSession(ChannelHandlerContext session) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void exceptionCaught(ChannelHandlerContext session, Throwable cause) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        ThreadManager.getInstance().addBackTask(new DataRunnable("测试的") {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }
                log.error("ttttttttttttttt");
            }
        });

        ThreadManager.getInstance().addBackTask(new DataRunnable("测试的") {

            @Override
            public void run() {
                log.error("ttttttttttttttt");
            }
        });

        ThreadGroup tg = new ThreadGroup("地图");
        Long thread = ThreadManager.getInstance().getThread(tg, "地图1");
        ThreadManager.getInstance().addTask(thread, new DataRunnable("地图1") {

            @Override
            public void run() {
                log.error("地图1");
            }
        });
    }
}
