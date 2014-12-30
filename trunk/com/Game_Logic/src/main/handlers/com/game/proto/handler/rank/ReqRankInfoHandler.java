package com.game.proto.handler.rank;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.RankMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqRankInfoHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqRankInfoHandler.class);

    @Override
    public void run() {
        // TODO 处理RankMessage.ReqRankInfo消息
        RankMessage.ReqRankInfoMessage reqMessage = (RankMessage.ReqRankInfoMessage) getMessage();
        RankMessage.ResRankInfoMessage.Builder builder4Res = RankMessage.ResRankInfoMessage.newBuilder();
    }
}
