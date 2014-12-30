package com.game.proto.handler.fight;

import com.game.engine.io.commmand.TcpHandler;
import com.game.proto.FightMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public final class ReqLearnSkillHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqLearnSkillHandler.class);

    @Override
    public void run() {
        // TODO 处理FightMessage.ReqLearnSkill消息
        FightMessage.ReqLearnSkillMessage reqMessage = (FightMessage.ReqLearnSkillMessage) getMessage();
        FightMessage.ResLearnSkillMessage.Builder builder4Res = FightMessage.ResLearnSkillMessage.newBuilder();
    }
}
