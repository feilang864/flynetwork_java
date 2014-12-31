/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.RunnableBase;
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
public abstract class MessagePool extends RunnableBase {

    private static final Logger logger = Logger.getLogger(MessagePool.class);

    /* 任务列表 */
    protected final List<MessageBean> messageQueue = Collections.synchronizedList(new LinkedList<MessageBean>());

    protected final Map<Long, ProtobufMessageConstructor> handlerMap = new HashMap<>(0);

    public MessagePool() {
    }

    /**
     * 增加消息id和消息构造器，消息处理器
     *
     * @param messageId
     * @param handel
     * @param message
     */
    public void registerHandlerMessage(long messageId, Class<? extends com.google.protobuf.Message> message, Class<? extends MessageHandler> handel) {
        ProtobufMessageConstructor messageHandler = new ProtobufMessageConstructor(messageId, handel, message);
        handlerMap.put(messageId, messageHandler);
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param mesg
     */
    public void addRecvMessage(MessageBean mesg) {
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
                ProtobufMessageConstructor get = handlerMap.get(msg.getMsgid());
                try {
                    //MessageHandler newInstance = get.getHandel().newInstance();
                    Message parseFrom = get.getMessage().newInstance().getParserForType().parseFrom(msg.getMsgbuffer());
                    //newInstance.setTCPHandler(parseFrom, get);
                    //newInstance.action();
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
