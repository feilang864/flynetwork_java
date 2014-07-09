/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.xmltest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Item {

    @Element
    private String code;
    @Element
    private String name;
    @Element
    private int quatity;

    public Item() {
        super();
    }

    public Item(String code, String name, int quatity) {
        super();
        this.code = code;
        this.name = name;
        this.quatity = quatity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return "Code:" + this.getCode() + " ; Name: " + this.getName() + " ; Quatity: " + this.getQuatity();
    }

}
