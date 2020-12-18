package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginServlet extends HttpServlet{
    public static Logger logger = Logger.getLogger(LoginServlet.class);
    public void service(HttpRequest request, HttpResponse response){
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        try (
                RandomAccessFile raf = new RandomAccessFile("user.dat","r");
        ){

            byte[] data = new byte[32];
            for(int i=0;i<raf.length()/100;i++){
                raf.seek(100*i);
                raf.read(data);
                String username = new String(data,"UTF-8").trim();
                raf.read(data);
                String pwd = new String(data,"UTF-8").trim();
                logger.info(uname+","+password+","+username+","+pwd);
                if(uname.equals(username)&&password.equals(pwd)){
                    File loginPage = new File("./webapps/myweb/login_success.html");
                    response.setEntity(loginPage);
                    return;
                }
            }
            File loginFailPage = new File("./webapps/myweb/login_fail.html");
            response.setStatusCode(404);
            response.setStatusReason("not found");
            response.setEntity(loginFailPage);
        } catch (IOException e) {
//            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
    }
}
