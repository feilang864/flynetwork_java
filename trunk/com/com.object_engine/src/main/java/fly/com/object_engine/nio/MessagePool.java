/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio;

import fly.com.object_engine.struct.ObjectConfig;
import fly.com.object_engine.thread.RunnableBase;
import io.netty.channel.ChannelHandlerContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class MessagePool extends RunnableBase {

    private static final Logger logger = Logger.getLogger(MessagePool.class);
    private static final long serialVersionUID = -3912073846429079071L;

    /* 任务列表 */
    protected final List<MessageBean> messageQueue = Collections.synchronizedList(new LinkedList<MessageBean>());

    protected final HashMap<Long, ProtobufMessageConstructor> handlerMap = new HashMap<>(0);
    private final HashMap<ChannelHandlerContext, Long> connectionIdMap = new HashMap<>(0);
    private final HashMap<Long, ChannelHandlerContext> connectionMap = new HashMap<>(0);

    public MessagePool() {
    }

    public void addConnection(ChannelHandlerContext context) {
        synchronized (connectionMap) {
            long id = ObjectConfig.getId();
            connectionIdMap.put(context, id);
            connectionMap.put(id, context);
        }
    }

    public void removeConnection(ChannelHandlerContext context) {
        synchronized (connectionMap) {
            Long remove = connectionIdMap.remove(context);
            connectionMap.remove(remove);
        }
    }

    /**
     * 增加消息id和消息构造器，消息处理器
     *
     * @param messageId
     * @param handel
     * @param message
     * @param threadId 执行线程id，默认可以是0,表示后台执行
     */
    public void registerHandlerMessage(long messageId,
            Class<? extends com.google.protobuf.GeneratedMessage> message,
            Class<? extends MessageHandler> handel,
            long threadId) {
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
                    this.action(msg);
                } catch (Exception ex) {
                    logger.error("工人<“" + Thread.currentThread().getName() + "”> 执行任务<" + msg.getMsgid() + "(“" + get.getMessage().getName() + "”)> 遇到错误: " + ex);
                    ex.printStackTrace();
                }
            }
        }
        logger.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
    }

    public abstract void action(MessageBean msg);

    public abstract void write(MessageBean msg);
}
