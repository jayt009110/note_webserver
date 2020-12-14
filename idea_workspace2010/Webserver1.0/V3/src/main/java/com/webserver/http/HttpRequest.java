package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private  String uri;
    private  String protocol;

    private Socket socket;
    private Map<String,String> header = new HashMap<String, String>();
    public HttpRequest(Socket socket){
        System.out.println("准备解析HTTP请求");
        this.socket = socket;
        //解析消息行
        parseRequest();
        //解析请求头
        parseHeader();
        //解析消息正文
        parseContent();

        System.out.println("请求解析完毕");
    }

    private void parseContent() {
        System.out.println("正在解析：消息正文");

        System.out.println("解析完毕");
    }

    private void parseRequest() {
        System.out.println("正在解析：消息行");
        try {
            String line = readLine();
            String[] str = line.split(" ");
            String method,uri,protocol;
            method = str[0];
            uri = str[1];
            protocol = str[2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("解析完毕");
    }

    private void parseHeader() {
        System.out.println("正在解析：请求头");
        try {
            while (true){
                String line1 = readLine();
                if("".equals(line1)){
                    break;
                }
                String[] str1 = line1.split("(:\\s)");
                header.put(str1[0],str1[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("解析完毕");
    }
    private String readLine() throws IOException {
        InputStream is = socket.getInputStream();
        char cur = 'a';
        char pre = 'a';
        StringBuilder builder = new StringBuilder();
        int d;
        //解析请求头
        while((d=is.read())!=-1){
            cur = (char)d;
            if(cur==10&&pre==13){
                break;
            }
            builder = builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }
}
