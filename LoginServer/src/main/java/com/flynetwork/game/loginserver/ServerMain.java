package com.flynetwork.game.loginserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 登录服务器
 *
 * @author Administrator
 */
public class ServerMain {

    public static void main(String[] args) {
        System.out.println(123123);
        try {
            Runtime.getRuntime().exec("E:\\13.bat");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}