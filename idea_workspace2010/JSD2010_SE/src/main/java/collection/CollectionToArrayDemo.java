package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 集合转换为数组
 *
 * Collection提供了一个方法toArray,将当前集合转换为数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

//        String[] arr = c.toArray(new String[c.size()]);
        String[] arr = c.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
    }
}
