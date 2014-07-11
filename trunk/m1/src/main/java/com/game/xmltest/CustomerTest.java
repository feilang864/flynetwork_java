/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.xmltest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class CustomerTest {

    public static void main(String[] args) throws Exception {
        Customer customer = create();
        String filePath = "d:/customerOrder.xml";
        //序列化，把对象转为xml
        //write(customer, filePath);
        //反序列化，xml转为对象
        read(filePath);
    }

    private static Customer create() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("apple", "苹果", 5));
        items.add(new Item("banana", "香蕉", 3));
        items.add(new Item("grape", "葡萄", 6));

        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order("order001", new Date(), items));
        orders.add(new Order("order002", new Date(), items));
        orders.add(new Order("order003", new Date(), items));
        orders.add(new Order("order004", new Date(), items));
        Customer customer = new Customer("1001", "张三", new Address("888888", "深圳科技园xx"), orders);
        return customer;
    }

    private static void write(Customer customer, String filePath) throws Exception {
        File file = new File(filePath);
        Serializer serializer = new Persister();
        serializer.write(customer, file);
    }

    private static void read(String filePath) throws Exception {
        File file = new File(filePath);
        Serializer serializer = new Persister();
        Customer customer = serializer.read(Customer.class, file);
        print(customer);
    }

    private static void print(Customer customer) {
        System.out.println("    " + customer.getCode());
        System.out.println("    " + customer.getName());
        System.out.println("    " + customer.getAddress().getName());

        for (Order order : customer.getOrders()) {
            System.out.println("        " + order.getCode());
            System.out.println("        " + order.getDate());
            for (Item item : order.getItems()) {
                System.out.println("            " + item.toString());
            }
        }
    }
}
