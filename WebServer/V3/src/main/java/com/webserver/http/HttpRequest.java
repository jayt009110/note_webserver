package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求对象
 * 该类的每一个实例用于表示浏览器发送过来的一个HTTP请求
 * HTTP协议要求一个请求由三部分组成:
 * 请求行，消息头，消息正文
 */
public class HttpRequest {
    //请求行相关信息
    private String method; //请求行中的请求方式
    private  String uri;  //请求行中的抽象路径
    private  String protocol; //请求行中的协议版本


    //消息头相关信息
    private Map<String,String> headers = new HashMap<>();

    //消息正文

    private Socket socket;
    public HttpRequest(Socket socket){
        System.out.println("httprequest:开始解析请求");

        this.socket = socket;

        //1.解析请求行
        parseRequest();
        //2.解析消息头
        parseHeaders();
        //3.解析消息正文
        parseContent();

        System.out.println("请求解析完毕");
    }
    private void parseRequest(){
        try {
            System.out.println("httprequest:开始解析请求行");
            String line = readLine();
            System.out.println("请求行:" + line);

            String[] str = line.split("\\s");
            method = str[0];
            uri = str[1];
            protocol = str[2];
            System.out.println("请求解析完毕");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void parseHeaders(){
        System.out.println("httprequest:开始解析消息头");
        try {
            while (true) {
                String head = readLine();
                if (head.isEmpty()) {
                    break;
                }
                String a = head.substring(0, head.indexOf(":"));
                String e = head.substring(head.indexOf(": ") + 1);
                headers.put(a, e);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("请求解析完毕");
    }
    private void parseContent(){
        System.out.println("httprequest:开始解析消息正文");

        System.out.println("请求解析完毕");
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
