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
public final class ReqShopBuyHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqShopBuyHandler.class);

    @Override
    public void run() {
        // TODO 处理ShopMessage.ReqShopBuy消息
        ShopMessage.ReqShopBuyMessage reqMessage = (ShopMessage.ReqShopBuyMessage) getMessage();
        ShopMessage.ResShopBuyMessage.Builder builder4Res = ShopMessage.ResShopBuyMessage.newBuilder();
    }
}
