/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.xmltest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.simpleframework.xml.Attribute;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Order {

	@Attribute
	private String code;
	@Attribute
	private Date date;
	@ElementList(required = false,type = Item.class)
	private List<Item> items = new ArrayList<Item>();
	
	public Order(){
		super();
	}
	public Order(String code, Date date, List<Item> items) {
		super();
		this.code = code;
		this.date = date;
		this.items = items;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
