package com.game.proto.handler.registerlogic;

import fly.com.object_engine.nio.MessageHandler;
import com.game.proto.RegisterLogicMessage;
import fly.game_logic.struct.map.player.Player;

/**
 *
 * @author Troy.Chen
 * @mail 492794628@qq.com
 * @phone 13882122019
 */
public final class ReqRegisterLogicHandler extends MessageHandler {

    @Override
    public void run() {
        // TODO 处理RegisterLogicMessage.ReqRegisterLogic消息
        RegisterLogicMessage.ReqRegisterLogicMessage reqMessage = (RegisterLogicMessage.ReqRegisterLogicMessage) getOthers().get("Message");

        RegisterLogicMessage.ResRegisterLogicMessage.Builder builder4Res = RegisterLogicMessage.ResRegisterLogicMessage.newBuilder();
    }
}
