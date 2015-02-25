package com.game.engine.nettypool.message;

import com.game.engine.struct.GameGlobal;
import com.game.engine.struct.thread.ThreadRunnable;
import com.game.engine.threadpool.ThreadManager;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 */
public class NettyMessagePool {

    private static final Logger log = Logger.getLogger(NettyMessagePool.class);

    private static final NettyMessagePool instance = new NettyMessagePool();

    public static NettyMessagePool getInstance() {
        return instance;
    }

    HashMap<Long, MessageHandler> handlerMap = new HashMap<>(0);
    MessageThread messageThread;

    public NettyMessagePool() {
        messageThread = new MessageThread();
        ThreadGroup tg = new ThreadGroup("Netty消息处理器");
        Long thread = ThreadManager.getInstance().getThread(tg, messageThread, "Netty消息处理器");
    }

    public void registerMessage(NettyMessageBean messageBean) {
        messageThread.addTask(messageBean);
    }

    public void registerHandlerMessage(long messageId, Class<? extends NettyTcpHandler> handel, Class<? extends com.google.protobuf.Message> message) {

    }

    class MessageHandler {

        long messageId;
        Class<? extends NettyTcpHandler> handel;
        Class<? extends com.google.protobuf.Message> message;

        public MessageHandler(long messageId, Class<? extends NettyTcpHandler> handel, Class<? extends com.google.protobuf.Message> message) {
            this.messageId = messageId;
            this.handel = handel;
            this.message = message;
        }

        public long getMessageId() {
            return messageId;
        }

        public void setMessageId(long messageId) {
            this.messageId = messageId;
        }

        public Class<? extends NettyTcpHandler> getHandel() {
            return handel;
        }

        public void setHandel(Class<? extends NettyTcpHandler> handel) {
            this.handel = handel;
        }

        public Class<? extends com.google.protobuf.Message> getMessage() {
            return message;
        }

        public void setMessage(Class<? extends com.google.protobuf.Message> message) {
            this.message = message;
        }

    }

    class MessageThread extends ThreadRunnable {

        /* 任务列表 */
        private final List<NettyMessageBean> taskQueue = Collections.synchronizedList(new LinkedList<NettyMessageBean>());

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param newTask
         */
        public void addTask(NettyMessageBean mesg) {
            synchronized (taskQueue) {
                taskQueue.add(mesg);
                /* 唤醒队列, 开始执行 */
                taskQueue.notify();
            }
            log.debug("接受消息 消息ID <" + mesg.getMsgid() + ">");
        }

        @Override
        public void run() {
            while (GameGlobal.getInstance().isRunning()) {
                NettyMessageBean msg = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && GameGlobal.getInstance().isRunning()) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(500);
                        } catch (InterruptedException ie) {
                            log.error(ie);
                        }
                    }
                    /* 取出任务执行 */
                    if (GameGlobal.getInstance().isRunning()) {
                        msg = taskQueue.remove(0);
                    }
                }

                if (msg != null) {
                    MessageHandler get = handlerMap.get(msg.getMsgid());
                    try {
                        NettyTcpHandler newInstance = get.getHandel().newInstance();
                        Message parseFrom = get.getMessage().newInstance().getParserForType().parseFrom(msg.getMsgbuffer());
                        newInstance.action();
                    } catch (InstantiationException | IllegalAccessException | InvalidProtocolBufferException e) {
                        log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + msg.getMsgid() + "(“" + get.getMessage().getName() + "”)> 遇到错误: " + e);
                        e.printStackTrace();
                    } catch (Exception ex) {
                        log.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + msg.getMsgid() + "(“" + get.getMessage().getName() + "”)> 遇到错误: " + ex);
                        ex.printStackTrace();
                    }
                    msg = null;
                }
            }
            log.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
        }
    }
}
