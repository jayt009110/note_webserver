package com.webserver.core;

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
            //读取请求行
            String line = readLine();
            System.out.println("请求行:"+line);

            String method,uri,protocol;
            //String[] str = line.split(" ");
            String[] str= line.split("\\s");
            method = str[0];
            uri = str[1];
            protocol = str[2];

            System.out.println(method);
            System.out.println(uri);
            System.out.println(protocol);

            String head;
//            boolean r = readLine().endsWith(res);
//            Collection<String> name = new ArrayList<>();
//            Collection<String> conment = new ArrayList<>();
            Map<String,String> headers = new HashMap<>();

            //读取消息头
            while(true){
                head =readLine();
//                String[] e = head.split(":"+"\\s");
//                name.add(e[0]);
//                conment.add(e[1]);
                if(head.isEmpty()){
                    break;
                }
                String a = head.substring(0,head.indexOf(":"));
                String e = head.substring(head.indexOf(": ")+1);
                headers.put(a,e);
            }
            System.out.println(headers);
            System.out.println("消息头输出完毕");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public String readLine() throws IOException {
       /*
            socket相同时，无论调用多少次getInputStream()方法，获取输入流始终是同一个
        */
        InputStream is = socket.getInputStream();
        StringBuilder builder = new StringBuilder();
        char pre ='a'; //上次读取到的字符
        char cur ='a'; //这次读取到的字符
        int d;
        while ((d=is.read())!=-1){
            cur = (char)d;
            if(cur==10&&pre==13){
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }
}
