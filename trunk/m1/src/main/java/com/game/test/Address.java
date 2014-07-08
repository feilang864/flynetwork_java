/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.test;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address {

	@Element
	private String code;
	@Element
	private String name;
	
	public Address(){
		super();
	}
	public Address(String code,String name){
		super();
		this.code = code;
		this.name = name;
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
}
