package com.game.proto.handler.shop;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.ShopMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqShopDataHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqShopDataHandler.class);

    @Override
    public void run() {
        // TODO 处理ShopMessage.ReqShopData消息
        ShopMessage.ReqShopDataMessage reqMessage = (ShopMessage.ReqShopDataMessage) getMessage();
        ShopMessage.ResShopDataMessage.Builder builder4Res = ShopMessage.ResShopDataMessage.newBuilder();
    }
}
