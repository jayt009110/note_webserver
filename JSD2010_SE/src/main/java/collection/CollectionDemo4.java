package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合之间的操作
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
//        Collection c1 = new ArrayList();
        Collection c1 = new HashSet();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1:"+c1);

        Collection c2 = new ArrayList();
        c2.add("ios");
        c2.add("android");
        c2.add("java");
        System.out.println("c2:"+c2);
        /*
            boolean addAll(Collection c)
            将给定集合所有元素添加到当前集合中，添加后当前集合发生了变化则返回true
         */
        c1.addAll(c2);
        System.out.println("c1:"+c1);

        Collection c3 = new ArrayList();
        c3.add("java");
        c3.add("ios");
        /*
            boolean containsAll(Collection c)
            判断当前集合是否包含给定集合中的所有元素
         */
        boolean contains = c1.containsAll(c3);
        System.out.println(contains);

        /*
            删除c1中与给定集合c3中的共有元素，注意：只能删除c1中的元素
         */
        c1.removeAll(c3);
        System.out.println("c1:"+c1);
        System.out.println("c3:"+c3);
    }

}
