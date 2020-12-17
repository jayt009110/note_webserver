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
        /*
            验证数据,如果上述四项存在null,或者年龄的字符串表示的不是一个整数时直接
            响应一个错误页面:reg_info_error.html,上面居中显示一行字:注册失败，输入信息有误
            此时不应当再执行下面的注册操作了
         */
        System.out.println("RegServlet:开始处理用户注册.......");
        //1通过request获取用户在页面上表单中输入的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
//        int age = Integer.parseInt(request.getParameter("age"));
        String agestr = request.getParameter("age");

        int age = Integer.parseInt(agestr);
        System.out.println(username+","+password+","+nickname+","+age);

        /*
            2将信息写入文件user.dat中
            每个用户的信息占用100字节，其中用户名，密码，昵称为字符串占用32字节
            年龄为int值占用4字节.
         */
         if(username==null||password==null||nickname==null||agestr==null||
                 !agestr.matches("[0-9]+")){
             File file = new File("./webnapps/myweb/reg_info_error.html");
             response.setEntity(file);
             return;
         }
        try (
                RandomAccessFile raf = new RandomAccessFile("user.dat","rw");

        ){
            /*
                判断是否为重复用户.
                先读取user.dat文件中现有的所有用户名，如果与当前注册的用户名一致，则直接响应
                页面:hava_user.html 提示用户名已存在，请重新注册
                否则才将该用户信息写入文件user.dat中完成注册
             */

            byte[] data = new byte[32];
            int line;

            for(int i=0;i<raf.length()/100;i++){
                raf.seek(100*i);
                raf.read(data);
                String uname = new String(data,"UTF-8").trim();

                if(username.equals(uname)){
                    File file = new File("webapps/myweb/have_user.html");
                    response.setEntity(file);
                    return;
                }

            }


            raf.seek(raf.length());
            writeLine(raf,username);
            writeLine(raf,password);
            writeLine(raf,nickname);
            raf.writeInt(age);
        } catch (IOException e) {
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
