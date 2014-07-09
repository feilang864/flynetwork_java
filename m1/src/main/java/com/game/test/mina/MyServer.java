/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.test.mina;
/**
 *
 * @author Administrator
 */
public class MyServer {

    public static void main(String[] args) {

        MinaServerApplication myapp = new MinaServerApplication();
        myapp.Start(9523);
        
    }

}