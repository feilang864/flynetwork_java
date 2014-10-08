/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.poolmessage;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import flynetwork.com.data.engine.manager.ThreadManager;
import flynetwork.com.data.engine.struct.thread.GameRunnable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class MessagePool {

    private static final MessagePool instance = new MessagePool();

    public static MessagePool getInstance() {
        return instance;
    }
    private static final Logger logger = Logger.getLogger(MessagePool.class);
    Map<Long, MessageHandler> handlerMap;
    MessageThread messageThread;

    public MessagePool() {
        handlerMap = new HashMap<>();
        messageThread = new MessageThread("Netty消息处理器");
        ThreadManager.getInstance().getWorkerThread(ThreadManager.getInstance().GlobeThreadGroup, messageThread, "Netty消息处理器");
    }

    public void registerMessage(MessageBean messageBean) {
        messageThread.addTask(messageBean);
    }

    public void registerHandlerMessage(long messageId, Class<? extends ActionMessageHandler> handel, Class<? extends com.google.protobuf.Message> message) {
        MessageHandler messageHandler = new MessageHandler(messageId, handel, message);
        handlerMap.put(messageId, messageHandler);
    }

    class MessageHandler {

        long messageId;
        Class<? extends ActionMessageHandler> handel;
        Class<? extends com.google.protobuf.Message> message;

        public MessageHandler(long messageId, Class<? extends ActionMessageHandler> handel, Class<? extends com.google.protobuf.Message> message) {
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

        public Class<? extends ActionMessageHandler> getHandel() {
            return handel;
        }

        public void setHandel(Class<? extends ActionMessageHandler> handel) {
            this.handel = handel;
        }

        public Class<? extends com.google.protobuf.Message> getMessage() {
            return message;
        }

        public void setMessage(Class<? extends com.google.protobuf.Message> message) {
            this.message = message;
        }

    }

    class MessageThread extends GameRunnable {

        public MessageThread(String Name) {
            super(Name);
        }

        /* 任务列表 */
        private final List<MessageBean> taskQueue = Collections.synchronizedList(new LinkedList<MessageBean>());

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param newTask
         */
        public void addTask(MessageBean mesg) {
            synchronized (taskQueue) {
                taskQueue.add(mesg);
                /* 唤醒队列, 开始执行 */
                taskQueue.notify();
            }
            logger.debug("接受消息 消息ID <" + mesg.getMsgid() + ">");
        }

        @Override
        public void run() {
            while (ThreadManager.getInstance().isRunning()) {
                MessageBean msg = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && ThreadManager.getInstance().isRunning()) {
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(500);
                        } catch (InterruptedException ie) {
                            logger.error(ie);
                        }
                    }
                    /* 取出任务执行 */
                    if (ThreadManager.getInstance().isRunning()) {
                        msg = taskQueue.remove(0);
                    }
                }

                if (msg != null) {
                    MessageHandler get = handlerMap.get(msg.getMsgid());
                    try {
                        ActionMessageHandler newInstance = get.getHandel().newInstance();
                        Message parseFrom = get.getMessage().newInstance().getParserForType().parseFrom(msg.getMsgbuffer());
                        newInstance.setTCPHandler(parseFrom, get);
                        newInstance.action();
                    } catch (InstantiationException | IllegalAccessException | InvalidProtocolBufferException e) {
                        logger.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + msg.getMsgid() + "(“" + get.getMessage().getName() + "”)> 遇到错误: " + e);
                        e.printStackTrace();
                    } catch (Exception ex) {
                        logger.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + msg.getMsgid() + "(“" + get.getMessage().getName() + "”)> 遇到错误: " + ex);
                        ex.printStackTrace();
                    }
                    msg = null;
                }
            }
            logger.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
        }
    }
}
