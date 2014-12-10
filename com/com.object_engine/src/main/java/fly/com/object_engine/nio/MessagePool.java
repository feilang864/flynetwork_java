/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.TaskHandlerBase;
import fly.com.object_engine.thread.TaskThread;
import fly.com.object_engine.thread.ThreadManager;
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
    private static final Logger logger = Logger.getLogger(MessagePool.class);

    public static MessagePool getInstance() {
        return instance;
    }
    Map<Long, MessageHandler> handlerMap = new HashMap<>();
    MessageThread messageThread;

    public MessagePool() {
        messageThread = new MessageThread(ObjectConfig.getThreadGroup(), "Netty消息处理器");
        ThreadManager.getInstance().addActionThread(messageThread);
    }

    public void registerMessage(MessageBean messageBean) {
        messageThread.addTask(messageBean);
    }

    public void registerHandlerMessage(long messageId, Class<? extends HandlerAction> handel, Class<? extends com.google.protobuf.Message> message) {
        MessageHandler messageHandler = new MessageHandler(messageId, handel, message);
        handlerMap.put(messageId, messageHandler);
    }

    class MessageHandler {

        long messageId;
        Class<? extends HandlerAction> handel;
        Class<? extends com.google.protobuf.Message> message;

        public MessageHandler(long messageId, Class<? extends HandlerAction> handel, Class<? extends com.google.protobuf.Message> message) {
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

        public Class<? extends HandlerAction> getHandel() {
            return handel;
        }

        public void setHandel(Class<? extends HandlerAction> handel) {
            this.handel = handel;
        }

        public Class<? extends com.google.protobuf.Message> getMessage() {
            return message;
        }

        public void setMessage(Class<? extends com.google.protobuf.Message> message) {
            this.message = message;
        }

    }

    public class MessageThread extends TaskThread {

        public MessageThread(ThreadGroup threadGroup, String threadName) {
            super(threadGroup, threadName);
        }

        /* 任务列表 */
        private final List<MessageBean> messageQueue = Collections.synchronizedList(new LinkedList<MessageBean>());

        /**
         * 增加新的任务 每增加一个新任务，都要唤醒任务队列
         *
         * @param mesg
         */
        public void addTask(MessageBean mesg) {
            synchronized (messageQueue) {
                messageQueue.add(mesg);
                /* 唤醒队列, 开始执行 */
                messageQueue.notify();
            }
            logger.debug("接受消息 消息ID <" + mesg.getMsgid() + ">");
        }

        @Override
        public void run() {
            while (ObjectConfig.isRunning()) {
                MessageBean msg = null;
                synchronized (messageQueue) {
                    if (messageQueue.isEmpty()) {
                        try {
                            messageQueue.wait(200);
                        } catch (InterruptedException ex) {
                        }
                    } else {
                        msg = messageQueue.remove(0);
                    }
                }
                if (msg != null) {
                    MessageHandler get = handlerMap.get(msg.getMsgid());
                    try {
                        HandlerAction newInstance = get.getHandel().newInstance();
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
