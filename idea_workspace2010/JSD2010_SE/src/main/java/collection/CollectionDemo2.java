package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合的某些操作是依靠元素的equals方法进行的
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        Collection c = new HashSet();
        c.add(new Point(1, 2));
        c.add(new Point(3, 4));
        c.add(new Point(5, 6));
        c.add(new Point(7, 8));
        c.add(new Point(9, 10));
        c.add(new Point(11, 12));
        c.add(new Point(1, 2));
        /*
            集合的toString方法在输出时，每个元素也是依靠元素的toString方法来表示内容的
         */
        System.out.println(c);

        Point p = new Point(1, 2);
        //c.add(p)
        /*
            boolean contains(Object o)
            判断当前集合是否包含给定元素
            判断是否包含的依据是当前集合中是否存在与给定集合equals比较为true的元素
         */
        boolean contains = c.contains(p);
        System.out.println(contains);

        /*
            删除给定元素也是删除与给定元素equals比较为true的，对于List集合而言，重复元素
            只能删除一次
         */
        c.remove(p);
        System.out.println(c);
    }
}
