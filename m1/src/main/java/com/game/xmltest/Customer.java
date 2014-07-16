/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.xmltest;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Customer {

    //@Element(required = true) 默认为true
    //@Element(type = void.class) 默认为void 
    @Attribute(name = "code", required = false)
    private String code;
    @Attribute(name = "name", required = false)
    private String name;
    @Element(name = "Address", required = false)
    private Address address;

    private List<Order> orders = new ArrayList<Order>();

    public Customer() {
        super();
    }

    public Customer(String code, String name, Address address,
            List<Order> orders) {
        super();
        this.code = code;
        this.name = name;
        this.address = address;
        this.orders = orders;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
