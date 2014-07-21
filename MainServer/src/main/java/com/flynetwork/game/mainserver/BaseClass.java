/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flynetwork.game.mainserver;

import org.apache.log4j.Logger;


/**
 *
 * @author Administrator
 */
public class BaseClass {
protected Logger logger;
    public BaseClass(String name) {
        logger=Logger.getLogger(name);
    }
    
    
    
}
