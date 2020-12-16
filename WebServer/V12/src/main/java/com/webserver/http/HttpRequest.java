package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求对象
 * 该类的每一个实例用于表示浏览器发送过来的一个HTTP请求
 * HTTP协议要求一个请求由三部分组成:
 * 请求行，消息头，消息正文
 */
public class HttpRequest {
    //请求行相关信息
    private String method; //请求行中的请求方式
    private  String uri;  //请求行中的抽象路径
    private  String protocol; //请求行中的协议版本

    private String requestURI; //抽象路径中的请求部分,uri"?"左侧内容
    private  String queryString;  //抽象路径中的参数部分uri"?"右侧内容
    private  Map<String,String> parameters = new HashMap<>(); //保存每一组参数

    //消息头相关信息
    private Map<String,String> headers = new HashMap<>();

    //消息正文

    private Socket socket;
    public HttpRequest(Socket socket) throws EmptyRequestException {
        System.out.println("httprequest:开始解析请求");

        this.socket = socket;

        //1.解析请求行
        parseRequest();
        //2.解析消息头
        parseHeaders();
        //3.解析消息正文
        parseContent();

        System.out.println("请求解析完毕");
    }
    private void parseRequest() throws EmptyRequestException {
        try {
            System.out.println("httprequest:开始解析请求行");
            String line = readLine();
            if(line.isEmpty()){
                throw new EmptyRequestException("request为空");
            }
            System.out.println("请求行:" + line);

            String[] str = line.split("\\s");
            method = str[0];
            uri = str[1];
            protocol = str[2];
            parseURI();
            System.out.println("请求解析完毕");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void parseURI() {
        System.out.println("HttpRequest:进一步解析uri.....");
        /*
            对于不含有参数的uri而言则不需要过多的处理，只需要将uri的值直接赋值给request
            因为requestURI专门用来保存uri的请求部分，不含有参数而定uri就是请求部分,

            对于含有参数的uri,我们要进一步拆分:
            首先按照"?"将uri拆成两部分:请求部分和参数部分
            然后将请求部分赋值给属性requestURI
            参数部分赋值给属性queryString

            只有再对queryString进一步拆分出每一组参数:
            首先按照"&"拆分出每个参数，然后再将每个参数按照"="拆分为参数名和参数值
            将参数名作为key,参数值作为value保存到parameters这个Map即可
         */
        //先对uri进行解码，将%XX的16进制表示的信息还原为对应的文字

        try {
            uri = URLDecoder.decode(uri,"UTF-8");
        } catch (UnsupportedEncodingException e) {


        }
        if(uri.contains("?")) {
            String[] str = uri.split("\\?");
            requestURI = str[0];
            if (str.length > 1) {
                queryString = str[1];
                String[] query = queryString.split("&");
                for (int i = 0; i < query.length; i++) {
                    String[] line = query[i].split("=");
                    if (line.length > 1) {
                        parameters.put(line[0], line[1]);
                    } else {
                        parameters.put(line[0], null);
                    }

                }
            }
        }else {
            requestURI =uri;
        }



        System.out.println("requestURI:"+requestURI);
        System.out.println("queryString:"+queryString);
        System.out.println("parameters:"+parameters);
        System.out.println("HttpRequest:uri解析完毕");
    }
    private void parseHeaders(){
        System.out.println("httprequest:开始解析消息头");
        try {
            while (true) {
                String head = readLine();
                if (head.isEmpty()) {
                    break;
                }
                String a = head.substring(0, head.indexOf(":"));
                String e = head.substring(head.indexOf(": ") + 1);
                headers.put(a, e);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("请求解析完毕");
    }
    private void parseContent(){
        System.out.println("httprequest:开始解析消息正文");

        System.out.println("请求解析完毕");
    }


    private String readLine() throws IOException {
       /*
            socket相同时，无论调用多少次getInputStream()方法，获取输入流始终是同一个
        */
        InputStream is = socket.getInputStream();
        StringBuilder builder = new StringBuilder();
        char pre ='a'; //上次读取到的字符
        char cur ='a'; //这次读取到的字符
        int d;
        while ((d=is.read())!=-1){
            cur = (char)d;
            if(cur==10&&pre==13){
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }

    public String getMethod() {

        return method;
    }

    public String getUri() {

        return uri;
    }

    public String getProtocol() {

        return protocol;
    }

    public String getHeader(String name) {

        return headers.get(name);
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getQueryString() {
        return queryString;
    }

    /**
     * 根据参数名获取参数值
     * @param name
     * @return
     */
    public String getParameter(String name){
        return parameters.get(name);
    }
}
