package com.game.io.mina.conf;

import org.simpleframework.xml.Element;

/**
 *
 * @author Vicky
 */
public abstract class ServerConfig {

    // 服务器标识
    @Element
    private int id;
    
    // 服务器名称
    @Element
    private String name;
    
    // 服务器渠道
    @Element
    private String web;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeb() {
        return this.web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
