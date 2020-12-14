package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合提供了统一的遍历元素的方式，迭代器模式
 * Iterator iterator()
 * 该方法会返回一个迭代器，使用这个迭代器即可遍历当前集合元素
 *
 *
 * java.util.Iterator 接口：迭代器
 * 迭代器遍历集合遵循的方式为：问，取，删.(其中删除元素不是遍历过程中的必要操作)
 *
 * 不同集合都提供了用于遍历自身元素的迭代器实现类，我们无需知道他们的名字，只将
 * 它们以Iterator的角度进行操作即可
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println("c:"+c);

        /*
            boolean hasNext()
            判断集合中国是否还有下一个元素可以获取，第一次调用时判断是否有第一个元素
            依次类推，这个就是迭代器"问"的过程
         */
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
//            Object str = iterator.next();
            /*
                E next()
                获取集合下一个元素
                这个就是迭代器"取"的过程
             */
            String str = (String)iterator.next();
            System.out.println(str);
            if("#".equals(str)){
                /*
                    迭代器要求在遍历过程中不能通过集合的方法增删元素，否则抛出异常

                 */
//                c.remove(str);
                iterator.remove();
            }
        }
        System.out.println(c);

    }
}
