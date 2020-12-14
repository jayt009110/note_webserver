package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * java.util.List接口
 * List继承自Collection，代表的是可以放重复元素并且有序的集合
 * List提供了一套可以通过下标操作元素的方法，使用更灵活
 * List常用实现类；
 * java.util.ArrayList:内部使用数组实现，查询性能更好
 * java.util.LinkedList:内部使用链表实现，增删性能更好
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        /*
            LIst专属方法
            E get(int index)
            获取List集合中指定位置的元素
         */
        String str = list.get(4);
        System.out.println(str);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        /*
            E set(int index,E e)
            将给定元素设置到指定位置上，返回值为原位置元素（被替换元素）
         */
        /*
            不创建新集合的前提下，反转
         */
        for(int i=0;i<list.size()/2;i++){
            String j = list.get(i);
            String str1 = list.set(list.size()-i-1,j);
            list.set(i,str1);

        }
        /*
            Collections是集合的工具类，提供的静态方法reverse是反转集合操作
         */
//        Collections.reverse(list);
        System.out.println(list);
    }
}
