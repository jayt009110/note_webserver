package com.webserver.core;

import com.webserver.http.HttpRequest;

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
            //处理请求
            //通过request获取抽象路径
            String path = request.getUri();
            File file = new File( "./webapps"+path);
            if(file.exists()&&file.isFile()){
                System.out.println("该资源已找到！！");
                //响应客户端
                OutputStream os = socket.getOutputStream();
            /*
                http/1.1 200 OK(CRLF)
                Content-Type:text/html(CRLF)
                Content-Length:2546(CRLF)(CRLF)
                1011111.....
             */
                System.out.println("开始发送响应");
                //1 发送状态行
                System.out.println("开始发送状态行");
                String line = "HTTP/1.1 200 OK";
                os.write(line.getBytes("ISO8859-1"));
                os.write(13);
                os.write(10);
                System.out.println("状态行发送完毕");
                //2发送响应头
                System.out.println("开始发送响应头");
                String content_type ="Content-Type: text/html";
                os.write(content_type.getBytes("ISO8859-1"));
                os.write(13);
                os.write(10);


                String content_length = "Content-Length: "+file.length();
                os.write(content_length.getBytes("ISO8859-1"));
                os.write(13);
                os.write(10);

                os.write(13);
                os.write(10);
                System.out.println("响应头发送完毕");

                //3发送消息正文
                System.out.println("开始发送消息正文");
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[1024*10];
                int d;
                while((d=fis.read(data))!=-1){
                    os.write(data,0,d);
                }
                System.out.println("消息正文发送完毕");
                //处理请求

            }
            else {
                //响应404
                System.out.println("该资源不存在");
                File not_found = new File("./webapps/root/404.html");
                OutputStream os = socket.getOutputStream();
                System.out.println("开始发送响应");
                //1 发送状态行
                System.out.println("开始发送状态行");
                String line = "HTTP/1.1 404 NotFound";
                os.write(line.getBytes("ISO8859-1"));
                os.write(13);
                os.write(10);
                System.out.println("状态行发送完毕");
                //2发送响应头
                System.out.println("开始发送响应头");
                String content_type ="Content-Type: text/html";
                os.write(content_type.getBytes("ISO8859-1"));
                os.write(13);
                os.write(10);


                String content_length = "Content-Length: "+not_found.length();
                os.write(content_length.getBytes("ISO8859-1"));
                os.write(13);
                os.write(10);

                os.write(13);
                os.write(10);
                System.out.println("响应头发送完毕");

                //3发送消息正文
                System.out.println("开始发送消息正文");
                FileInputStream fis = new FileInputStream(not_found);
                byte[] data = new byte[1024*10];
                int d;
                while((d=fis.read(data))!=-1){
                    os.write(data,0,d);
                }
                System.out.println("消息正文发送完毕");


            }



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


