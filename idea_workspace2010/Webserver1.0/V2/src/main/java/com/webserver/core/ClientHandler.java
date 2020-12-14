package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){

        this.socket = socket;
    }
        public void run(){
            //1解析请求
            try {

                String line = readLine();
                String[] str = line.split(" ");
                String method,uri,protocol;
                method = str[0];
                uri = str[1];
                protocol = str[2];
//                builder.delete(0,builder.length());
                //解析消息头
                Map<String,String> header = new HashMap<String, String>();
                while (true){
                    String line1 = readLine();
                    if("".equals(line1)){
                        break;
                    }
                    String[] str1 = line1.split("(:\\s)");
                    header.put(str1[0],str1[1]);
                }
                System.out.println(header);
                //解析消息正文

            } catch (IOException e) {
                e.printStackTrace();
            }
            //2处理请求
            //3响应客户端
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
