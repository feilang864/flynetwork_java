package com.game.script.main;

import com.game.script.selectplayer.InitPlayerBufferScript;
import com.game.script.selectplayer.InitPlayerOnlineScript;
import com.game.script.selectplayer.InitPlayerTaskScript;
import org.apache.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class MainScript {

    private static final Logger logger = Logger.getLogger(MainScript.class);

    public MainScript() {

        logger.info("ccccccccccccccccccccccccccccccccccccccccc");
        logger.info(new InitPlayerOnlineScript().getName());
        logger.info(new InitPlayerBufferScript().getName());
        logger.info(new InitPlayerTaskScript().getName());
    }

}
