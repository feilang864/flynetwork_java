/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesr_logic.struct.script;

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

    private static final Logger logger = Logger.getLogger(GameScriptBase.class);

    public GameScriptBase() {
    }

    public GameScriptBase(String Name) {
        super(Name);
    }

    public abstract void action();
    private static final long serialVersionUID = -3139727905513324776L;

}
