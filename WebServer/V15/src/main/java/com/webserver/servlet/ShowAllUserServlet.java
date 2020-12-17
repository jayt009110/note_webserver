package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.vo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成包含user.dat文件中所有用户信息的动态页面
 */
public class ShowAllUserServlet {
    public void service(HttpRequest request, HttpResponse response){
        System.out.println("ShowAllUserServlet:开始处理用户请求列表页面");
        //先将user.dat文件中所有记录读取出来
        List<User> list = new ArrayList<>();//保存user.dat文件中所有用户信息
        try (
                RandomAccessFile raf = new RandomAccessFile("user.dat","r");
            ){
            for(int i=0;i<raf.length()/100;i++){
                //读取用户名
                byte[] data = new byte[32];
                raf.read(data);
                String uname = new String(data,"UTF-8").trim();
                //读取密码
                raf.read(data);
                String pwd = new String(data,"UTF-8").trim();
                //读取昵称
                raf.read(data);
                String nickname = new String(data,"UTF-8").trim();
                //读取年龄
                int age = raf.readInt();
                User user = new User(uname,pwd,nickname,age);
                list.add(user);
                System.out.println(user);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>用户详情</title>\n" +
                "</head>\n" +
                "    <body>\n" +
                "        <center>\n" +
                "            <h1>用户列表</h1>\n" +
                "            <table border=\"1\">\n" +
                "                <tr>\n" +
                "                    <td>用户名</td>\n" +
                "                    <td>密码</td>\n" +
                "                    <td>昵称</td>\n" +
                "                    <td>年龄</td>\n" +
                "                </tr>";
        for(User user:list){
            html +="<tr>\n" +
                    "                    <td>"+user.getUsername()+"</td>\n" +
                    "                    <td>"+user.getPassword()+"</td>\n" +
                    "                    <td>"+user.getNickname()+"</td>\n" +
                    "                    <td>"+user.getAge()+"</td>\n" +
                    "                </tr>";
        }
        html +="        </table>\n" +
                "        </center>\n" +
                "    </body>\n" +
                "</html>";
        //将生成好的html代码写入一个文件
        try {

            byte[] data = html.getBytes("UTF-8");
            //将生成页面内容设置到response中
            response.setData(data);
            response.putHeaders("Content-Type","text/html");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ShowAllUserServlet:处理用户请求列表页面完毕");
    }
}
