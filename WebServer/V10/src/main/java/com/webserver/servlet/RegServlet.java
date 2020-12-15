package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.*;
import java.util.Arrays;

/**
 * 用于处理用户注册业务
 */
public class RegServlet {
    public void service(HttpRequest request, HttpResponse response){
        System.out.println("RegServlet:开始处理用户注册.......");
        //1通过request获取用户在页面上表单中输入的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        int age = Integer.parseInt(request.getParameter("age"));

        System.out.println(username+","+password+","+nickname+","+age);
        /*
            2将信息写入文件user.dat中
            每个用户的信息占用100字节，其中用户名，密码，昵称为字符串占用32字节
            年龄为int值占用4字节.
         */
        try (
                RandomAccessFile raf = new RandomAccessFile("user.dat","rw");
                ){
            raf.seek(raf.length());
            writeLine(raf,username);
            writeLine(raf,password);
            writeLine(raf,nickname);
            raf.writeInt(age);

        }catch (IOException e) {
            e.printStackTrace();
        }

        //3响应客户端注册结果页面
        File file = new File("./webapps/myweb/reg_success.html");
        response.setEntity(file);

        System.out.println("RegServlet:处理用户注册完毕...........");
    }
    private static void writeLine(RandomAccessFile raf,String name) throws IOException {
        byte[] data = name.getBytes("UTF-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);
    }

}
