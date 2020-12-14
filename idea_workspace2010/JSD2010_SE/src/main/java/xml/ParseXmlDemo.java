package xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Attr;

import java.util.List;

/**
 * 使用DOM解析XML
 */
public class ParseXmlDemo {
    public static void main(String[] args) {
        /*
            使用DOM4J解析XML的大致步骤:
            1:创建SAXReader
            2:使用SAXReader读取xml文档生成Document对象
              该对象中包含了解析XML文档后生成的整棵树
            3:通过Document获取根元素
            4:从根元素开始按照xml文档的结构逐级获取子元素，以达到遍历xml文件的目的
         */
        try {
            //
            SAXReader reader = new SAXReader();

            //
            Document doc = reader.read("./emplist.xml");

            /*
                Document提供获取根元素方法:
                Element getRootElement()

                Element的每一个实例用于表示XML文档中的一个元素（一对标签）,通过它
                可以获取到其表示的这个标签的一切信息，常见的方法有:
                String getName()  获取标签名
                String getText()  获取标签中间文本（开始与结束标签之间的文本信息）
                Element element(String name)  获取指定名字的子标签
                List elements()   当前标签下获取所有子标签
                List elements(String name)  获取当前标签下所有指定的同名子标签
             */
            Element root= doc.getRootElement();
            String name = root.getName();
            System.out.println(name);

            List<Element> list = root.elements();
            System.out.println(list.size());


            for(Element e: list){
                //获取员工名字
                //1获取<emp>标签下<name>子标签
//                Element nameEle = e.element("name");
                //2获取<name> 标签中间的文本
//                String ename = nameEle.getText();
                String uname = e.elementText("name");
//                Element ageEle = e.element("age");
//                Integer age = Integer.parseInt(ageEle.getText());
//                String age = ageEle.getText();

                int age = Integer.parseInt(e.elementText("age"));

//                Element salaryEle = e.element("salary");
//                Integer salary = Integer.parseInt(salaryEle.getText());

                int salary = Integer.parseInt(e.elementText("salary"));


                //获取属性"id"
//                Attribute attr = e.attribute("id");
                int attr = Integer.parseInt(e.attributeValue("id"));
                System.out.println(attr+","+uname+","+age+","+salary);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
