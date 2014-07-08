/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.test;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class CustomerTest {

	public static void main(String[] args) throws Exception{
		Customer customer = create();
		String filePath = "d:/customerOrder.xml";
		//序列化，把对象转为xml
		write(customer,filePath);
		//反序列化，xml转为对象
		read(filePath);
	}
	

	private static  Customer create(){
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item("apple","苹果",5);
		Item item2 = new Item("banana","香蕉",3);
		Item item3 = new Item("grape","葡萄",6);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		List<Order> orders = new ArrayList<Order>();
		Order order1 = new Order("order001",new Date(),items);
		orders.add(order1);
		
		Address address = new Address("888888","深圳科技园xx");
		
		Customer customer = new Customer("1001","张三",address,orders);
		
		return customer;
	}
	
	private static void write(Customer customer,String filePath) throws Exception{
		File file = new File(filePath);
		Serializer serializer = new Persister();
		serializer.write(customer,file);
	}
	
	private static void read(String filePath) throws Exception{
		File file = new File(filePath);
		
		Serializer serializer = new Persister();
		Customer customer = serializer.read(Customer.class, file);
		
		print(customer);
	}
	
	private static void print(Customer customer){
		System.out.println("--"+customer.getCode());
		System.out.println("--"+customer.getName());
		System.out.println("--"+customer.getAddress().getName());
		
		for(Order order : customer.getOrders()){
			System.out.println("----"+order.getCode());
			System.out.println("----"+order.getDate());
			for(Item item : order.getItems()){
				System.out.println("------"+item.getCode());
				System.out.println("------"+item.getName());
				System.out.println("------"+item.getQuatity());
			}
		}
	}
}
