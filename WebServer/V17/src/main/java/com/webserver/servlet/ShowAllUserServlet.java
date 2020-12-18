package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.vo.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成包含user.dat文件中所有用户信息的动态页面
 */
public class ShowAllUserServlet extends HttpServlet{
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
        /*
            使用thymeleaf将数据与页面整合生成动态页面
         */
        /*
            Context用于保存所有需要在页面上展示的动态数据
         */
        Context context = new Context();
        context.setVariable("list",list);

        //初始化Thymeleaf模版引擎
        //1初始化模版解释器，用来告诉模版引擎有关模版页面的相关信息
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setTemplateMode("html"); //模版类型，指定为html
        resolver.setCharacterEncoding("UTF-8"); //模版使用的字符集（我们的页面都是UTF-8）
        //2实例化模版引擎
        TemplateEngine te = new TemplateEngine();
        te.setTemplateResolver(resolver); //设置模版解释器，使其了解模版相关信息

        /*
            String process(String path,Context text)
            模版引擎生成动态页面的方法
            参数1:模版页面的路径
            参数2:需要在页面上显示的数据（数据应当都放在这个Context中）
            返回值为生成好的html代码
         */
        String html = te.process("./webapps/myweb/userList.html",context);
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
