package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合只能存放引用类型元素，并且存放的式元素的引用（地址）
 */
public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Point p = new Point(1,2);

        c.add(p);
        System.out.println("p:"+p);
        System.out.println("c:"+c);

        p.setX(2);
        System.out.println("p:"+p);
        System.out.println("c:"+c);
    }
}
