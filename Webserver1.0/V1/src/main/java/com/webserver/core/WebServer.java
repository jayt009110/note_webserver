package com.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;

public class WebServer {
    private ServerSocket server;
    public WebServer(){
        try {
            System.out.println("正在建立客户端");
            server = new ServerSocket(8088);
            System.out.println("客户端已建立");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            System.out.println("等待客户端连接");
            server.accept();
            System.out.println("客户端已连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}
