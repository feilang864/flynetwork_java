/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamesr_logic.struct.goods;

import com.game_engine.struct.GameObject;
import com.gamesr_logic.struct.scene.map.spirit.player.GamePlayer;

/**
 *
 * @author Administrator
 */
public abstract class GoodsBase extends GameObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4692142376378209984L;

	public abstract void use(GamePlayer player);

    public abstract void unUse(GamePlayer player);
}
