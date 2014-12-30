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
public final class ReqShopSaleHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqShopSaleHandler.class);

    @Override
    public void run() {
        // TODO 处理ShopMessage.ReqShopSale消息
        ShopMessage.ReqShopSaleMessage reqMessage = (ShopMessage.ReqShopSaleMessage) getMessage();
        ShopMessage.ResShopSaleMessage.Builder builder4Res = ShopMessage.ResShopSaleMessage.newBuilder();
    }
}
