/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game_engine.data.log;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author fly_troy
 */
@Entity
public class CreatLog extends BaseLog {

    @Column
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
