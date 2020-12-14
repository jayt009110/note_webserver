package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        SAXReader sax = new SAXReader();
        try {
            Document doc = sax.read("./emplist.xml");
            Element root = doc.getRootElement();
            List<Element> ele = root.elements("dd");
            for(Element e:ele){
//                int salary = Integer.parseInt(e.elementText("horse"));
//                System.out.println(salary);
                String horse = e.elementText("tiger");
                System.out.println(horse);
//                int id = Integer.parseInt(e.attributeValue("id"));
//                System.out.println(id);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
