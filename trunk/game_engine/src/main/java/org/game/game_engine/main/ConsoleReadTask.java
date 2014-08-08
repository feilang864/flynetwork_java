/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.game.game_engine.main;

import org.game.game_engine.threadtools.BaseTask;

/**
 *
 * @author Administrator
 */
public class ConsoleReadTask extends BaseTask{

    @Override
    protected boolean needExecuteImmediate() {
        return false;
    }

    @Override
    public String info() {
        return "控制台命令读取识别";
    }

    @Override
    public void run() {
        
    }
    
}
