package com.webserver.core;

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.*;
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
            HttpResponse response = new HttpResponse(socket);
            //处理请求
            //通过request获取抽象路径
            String path = request.getUri();
            File file = new File( "./webapps"+path);
            if(file.exists()&&file.isFile()){
                System.out.println("该资源已找到！！");
                response.setEntity(file);
            }
            else {
                //响应404
                System.out.println("该资源不存在");
                File not_found = new File("./webapps/root/404.html");
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.setEntity(not_found);
            }

            //响应客户端
            response.flush();

        } catch (EmptyRequestException e){
            //单独 空请求异常，到那时不需要任何处理，捕获的意义在于忽略处理操作
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


