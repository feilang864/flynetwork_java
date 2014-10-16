/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.logic.tcpmessage;

import com.game.engine.messagepool.ActionMessageHandler;
import com.game.engine.messagepool.HandlerInfo;
import com.game.engine.messagepool.HandlerManager;
import com.game.engine.messagepool.MessageBean;
import com.game.engine.struct.GameGlobal;
import com.game.engine.struct.GameObject;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author fly_ty
 */
public class MessageManager extends GameObject implements Runnable {

    private static final long serialVersionUID = 3715744847097492073L;
    private static final Logger logger = Logger.getLogger(MessageManager.class);

    /* 任务列表 */
    private final List<MessageBean> taskQueue = Collections.synchronizedList(new LinkedList<MessageBean>());

    private static MessageManager instance = new MessageManager();

    public static MessageManager getInstance() {
        return instance;
    }

    /**
     * 增加新的任务 每增加一个新任务，都要唤醒任务队列
     *
     * @param mesg
     */
    public void addMsg(MessageBean mesg) {
        synchronized (taskQueue) {
            taskQueue.add(mesg);
            /* 唤醒队列, 开始执行 */
            taskQueue.notify();
        }
        logger.debug("接受消息 消息ID <" + mesg.getMsgid() + ">");
    }

    @Override
    public void run() {
        while (GameGlobal.getInstance().isRunning()) {
            MessageBean messageBean = null;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && GameGlobal.getInstance().isRunning()) {
                    try {
                        /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                        taskQueue.wait(500);
                    } catch (InterruptedException ie) {
                        logger.error(ie);
                    }
                }
                /* 取出任务执行 */
                if (GameGlobal.getInstance().isRunning()) {
                    messageBean = taskQueue.remove(0);
                }
            }

            if (messageBean != null) {
                HandlerInfo handlerInfo = HandlerManager.getInstance().getHandlerInfo(messageBean.getMsgid());
                ActionMessageHandler messageHandler = handlerInfo.getHandel();
                messageHandler.getParameter().setValue(ActionMessageHandler.SESION_Value, messageBean.getChannelHandlerContext());
                try {
                    messageHandler.setMessage(handlerInfo.getMessage(messageBean.getMsgbuffer()));
                    //MessageRunnable messageRunnable = new MessageRunnable(handlerInfo.threadID, messageHandler);

                } catch (InstantiationException | IllegalAccessException | InvalidProtocolBufferException e) {
                    logger.error("工人<“" + Thread.currentThread().getName() + "”> 执行处理消息ID<" + messageBean.getMsgid() + "> 遇到错误: " + e);
                    e.printStackTrace();
                }
                messageBean = null;
            }
        }
        logger.error("线程结束, 工人<“" + Thread.currentThread().getName() + "”>退出");
    }
}
