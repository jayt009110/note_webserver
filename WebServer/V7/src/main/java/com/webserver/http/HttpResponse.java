package com.webserver.http;

import java.io.*;
import java.net.Socket;

/**
 * 响应对象
 * 当前类的每一个实例表示给客户发送的一个HTTP响应
 * 一个响应应当包含三部分:状态行，响应头，响应正文
 */
public class HttpResponse {
    private Socket socket;
    //状态行相关信息
    private int statusCode = 200; //状态代码，默认值为200
    private String statusReason = "OK"; //状态描述，默认为OK
    //响应头相关信息

    //响应正文相关信息
    public HttpResponse(Socket socket){
        this.socket = socket;
    }
    private File entity;

    /**
     * 将当前响应对象内容以标准的HTTP响应格式发送给客户端
     */
    public void flush(){
        //发送一个响应
        //1发送状态行
        sendStatusLine();
        //2发送响应头
        sendHeaders();
        //3发送响应正文
        sendContent();

    }
    private void sendStatusLine(){
        //1 发送状态行
        System.out.println("开始发送状态行");
        try {
            String line = "HTTP/1.1"+" "+statusCode+" "+statusReason;
            System.out.println("状态行："+line);
            println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("状态行发送完毕");
    }
    private void sendHeaders(){
        System.out.println("开始发送响应头");
        try {

            String content_type ="Content-Type: text/html";

            println(content_type);


            String content_length = "Content-Length: "+entity.length();

            println(content_length);

            println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("响应头发送完毕");
    }
    private void sendContent(){
        System.out.println("开始发送消息正文");
        try {
            FileInputStream fis = new FileInputStream(entity);
            OutputStream os = socket.getOutputStream();
            byte[] data = new byte[1024*10];
            int d;
            while((d=fis.read(data))!=-1){
                os.write(data,0,d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("消息正文发送完毕");
    }
    private void println(String line) throws IOException {
        OutputStream os = socket.getOutputStream();
        os.write(line.getBytes("ISO8859-1"));
        os.write(13);
        os.write(10);
    }

    public File getEntity() {

        return entity;
    }

    public void setEntity(File entity) {

        this.entity = entity;
    }

    public int getStatusCode() {

        return statusCode;
    }

    public String getStatusReason() {

        return statusReason;
    }

    public void setStatusCode(int statusCode) {

        this.statusCode = statusCode;
    }

    public void setStatusReason(String statusReason) {

        this.statusReason = statusReason;
    }
}
