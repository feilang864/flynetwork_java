/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.struct.timetask;

import com.game_engine.struct.GameObject;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 * @phone 13882122019
 * @email 492794628@qq.com
 */
public class GameTimeTaskBase extends GameObject {

    Logger logger = Logger.getLogger(GameTimeTaskBase.class);

    public GameTimeTaskBase() {
    }

    public GameTimeTaskBase(Long ID, String Name) {
        super(ID, Name);
    }

}
