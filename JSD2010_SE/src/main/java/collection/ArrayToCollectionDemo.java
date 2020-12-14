package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为List集合
 * 数组的工具类:java.util.Arrays提供了一个静态方法：asList，可以将一个数组转换为一个
 * List集合
 */
public class ArrayToCollectionDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        System.out.println("array:"+ Arrays.toString(array));

        List<String> list = Arrays.asList(array);
        System.out.println(list.size());
        System.out.println("List:"+list);
        /*
            通过数组转换来的集合，对该集合的操作就是对原数组的操作
         */
        list.set(2,"3");
        System.out.println("List:"+list);
        System.out.println("array:"+Arrays.toString(array));

        /*
            由于数组是定长的，因此该集合会影响元素个数的操作都是不支持的，调用后
            会抛出异常
         */
//        list.add("six");
//        list.remove("3");
//        System.out.println("List:"+list);
//        System.out.println("array:"+Arrays.toString(array));

//        List<String> list2 = new ArrayList<>();
//        list2.addAll(list);
        /*
            所有集合都支持一个参数为Collection的构造方法，目的是创建当前集合的同时
            包含给定集合中的所有元素
         */
        List<String> list2 = new ArrayList<>(list);
        System.out.println("list2:"+list2);
        list2.add("six");
        System.out.println("list2:"+list2);
    }
}
