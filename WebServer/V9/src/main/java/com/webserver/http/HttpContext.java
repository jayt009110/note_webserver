package com.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP协议规定的内容都定义在这里，以便将来重用
 */
public class HttpContext {
    /**
     * Content-Type信息
     * key:资源的后缀名
     * value:对应的Content-Type的值
     */
    private static Map<String,String> mimeMapping = new HashMap<>();
    static {
        initMimeMapping();
    }
    private static void initMimeMapping(){
        mimeMapping.put("html","text/html");
        mimeMapping.put("css","text/css");
        mimeMapping.put("js","application/javascript");
        mimeMapping.put("png","image/png");
        mimeMapping.put("jpg","image/jpeg");
        mimeMapping.put("gif","image/gif");
    }

    /**
     * 根据资源后缀名获取对应的Content-Type的值
     * @param ext
     * @return
     */
    public static String getMimeType(String ext){
        return mimeMapping.get(ext);
    }
}
