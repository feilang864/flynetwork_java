package com.game.engine.test;

import com.game.engine.nettypool.NettyMessageHandler;
import com.game.engine.nettypool.NettyTcpClient;
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
                log.info("channelActive -> ");
            }

            @Override
            public void readMessage(NettyMessageBean msg) {
                log.info("tcpServer readMessage -> " + msg.getMsgid() + " -> " + new String(msg.getMsgbuffer()));
                msg.getChannelHandlerContext().writeAndFlush(msg);
            }

            @Override
            public void closeSession(ChannelHandlerContext session) {
                log.info("closeSession -> ");
            }

            @Override
            public void exceptionCaught(ChannelHandlerContext session, Throwable cause) {
                log.info("exceptionCaught -> " + cause.getMessage());
            }
        });
//        tcpServer.start();
        NettyTcpClient tcpClient = new NettyTcpClient("127.0.0.1", 9527, true, new NettyMessageHandler() {

            @Override
            public void channelActive(ChannelHandlerContext session) {
                String string = "dfsfsfsdf";
                session.channel().writeAndFlush(new NettyMessageBean(10001, string.getBytes()));
            }

            @Override
            public void readMessage(NettyMessageBean msg) {
                log.info("tcpClient readMessage -> " + msg.getMsgid() + " -> " + new String(msg.getMsgbuffer()));
            }

            @Override
            public void closeSession(ChannelHandlerContext session) {
            }

            @Override
            public void exceptionCaught(ChannelHandlerContext session, Throwable cause) {
            }
        });
        tcpClient.Connect();
//
//        String string = "dfsfsfsdf";
//        tcpClient.sendMsg(new NettyMessageBean(10001, string.getBytes()));

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
