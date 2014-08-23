/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.script;

import com.game_engine.struct.GameObject;
import org.apache.log4j.Logger;

/**
 * 脚本
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public abstract class GameScriptBase extends GameObject {

    Logger logger = Logger.getLogger(GameScriptBase.class);

    public GameScriptBase() {
    }

    public GameScriptBase(Long ID, String Name) {
        super(ID, Name);
    }

    public abstract void action();

}
