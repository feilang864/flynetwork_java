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
public final class ReqUseSkillHandler extends TcpHandler {

    private static final Logger log = LoggerFactory.getLogger(ReqUseSkillHandler.class);

    @Override
    public void run() {
        // TODO 处理FightMessage.ReqUseSkill消息
        FightMessage.ReqUseSkillMessage reqMessage = (FightMessage.ReqUseSkillMessage) getMessage();
        FightMessage.ResUseSkillMessage.Builder builder4Res = FightMessage.ResUseSkillMessage.newBuilder();
    }
}
