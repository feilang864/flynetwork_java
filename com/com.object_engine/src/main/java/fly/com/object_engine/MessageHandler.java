/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine;

import fly.com.object_engine.thread.TaskHandlerBase;

/**
 *
 * @author Administrator
 */
public class MessageHandler extends TaskHandlerBase {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MessageHandler.class);
    private String str = "我是测试的";

    public MessageHandler(int actionThreadId) {
        super(actionThreadId, "我是测试的");
    }

    @Override
    public void action() {
        logger.error(str);
    }

}
