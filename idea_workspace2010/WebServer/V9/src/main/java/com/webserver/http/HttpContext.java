package com.webserver.http;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
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
//        mimeMapping.put("html","text/html");
//        mimeMapping.put("css","text/css");
//        mimeMapping.put("js","application/javascript");
//        mimeMapping.put("png","image/png");
//        mimeMapping.put("jpg","image/jpeg");
//        mimeMapping.put("gif","image/gif");
        /*
            通过解析config/web.xml文件初始化mimeMapping
            将根标签下所有名为<mime-mapping>的子标签获取到
            并将其中的子标签:
            <extension>的中间文本作为key
            <mime-type>的中间文本作为value
            保存到mimeMapping这个map中
            初始化完毕后，mimeMapping应该有1011个元素
         */
        SAXReader sax = new SAXReader();
        try {
            Document doc = sax.read("./config/web.xml");
            Element root = doc.getRootElement();
            List<Element> ele = root.elements("mime-mapping");
             for(Element e:ele){
                 String key = e.elementText("extension");
                 String value = e.elementText("mime-type");
                 mimeMapping.put(key,value);
             }
            System.out.println(mimeMapping.size());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
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
