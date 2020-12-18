package com.webserver.core;

import com.webserver.servlet.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务端会重用的内容都放在这里
 */
public class ServerContext {
    private static Map<String, HttpServlet> servletMapping = new HashMap<>();

    static{
        try {
            initServletMapping();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void initServletMapping() throws Exception {
//        servletMapping.put("/myweb/regUser",new RegServlet());
//        servletMapping.put("/myweb/loginUser",new LoginServlet());
//        servletMapping.put("/myweb/changePassword",new ChangePassword());
//        servletMapping.put("/myweb/ShowAllUser",new ShowAllUserServlet());
        /*
            解析config/servlets.xml
            将根标签下所有子标签<servlets>获取到，并将其中的属性path的值作为key
            className属性的值利用反射实例化对应的类并作为value
            初始化servletMapping这个Map
         */
        SAXReader sax = new SAXReader();
        Document doc = sax.read("./config/servlets.xml");
        Element element =  doc.getRootElement();
        List<Element> list = element.elements("servlet");
        for (Element e:list){
            String path = e.attributeValue("path");
            String classname = e.attributeValue("classname");
            System.out.println(path+","+classname);
            Class cls = Class.forName(classname);
            HttpServlet obj = (HttpServlet) cls.newInstance();
            servletMapping.put(path,obj);
        }


    }
    public static Map<String, HttpServlet> getservletMapping() {
        return servletMapping;
    }
}
