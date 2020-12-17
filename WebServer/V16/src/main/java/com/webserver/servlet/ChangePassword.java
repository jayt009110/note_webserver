package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class ChangePassword {
    public void service(HttpRequest request, HttpResponse response){
        String uname = request.getParameter("username");
        String pwd = request.getParameter("new_password");
        String old_pwd = request.getParameter("old_password");
        System.out.println("uname:"+uname+","+pwd);
        try(
                RandomAccessFile raf = new RandomAccessFile("user.dat","rw");


        ) {
            byte[] data = new byte[32];
            raf.read(data);
            String username = new String(data,"UTF-8").trim();
            System.out.println("用户名:"+uname+","+username);
            for(int i=0;i<raf.length()/100;i++){
                if(uname.equals(username)) {
                    raf.read(data);
                    String password = new String(data, "UTF-8").trim();
                    System.out.println("新旧密码:"+pwd+","+password);
                    if (!old_pwd.equals(password)) {
                        File changePage = new File("./webapps/myweb/ch_password_fail.html");
                        response.setEntity(changePage);
                        return;
                    } else {
                        raf.seek(32+100*i);
                        data = pwd.getBytes("UTF-8");
                        data = Arrays.copyOf(data, 32);
                        raf.write(data);
                        File changePwd = new File("./webapps/myweb/ch_password_success.html");
                        response.setEntity(changePwd);

                    }
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
