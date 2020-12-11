package com.webserver.core;

import com.webserver.http.HttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.*;

/**
 * 处理与某个客户端的HTTP交互
 * 由于HTTP要求客户端的交互采取一问一答，因此流程分为三步:
 * 1.解析请求（读取客户端发来的HTTP请求内容）
 * 2.处理请求
 * 3.响应客户端(发送一个HTTP响应客户端)
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){

        this.socket = socket;
    }
    public void run(){

        try {
            //解析请求
            HttpRequest request = new HttpRequest(socket);
            //处理请求
            //响应客户端
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    }


