package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 增强型for循环，又称为新循环，JDK5之后推出的特性，使得我们可以使用相同的语法遍历集合
 * 合成数组
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        for(int i=0;i<array.length;i++){
            String str = array[i];
            System.out.println(str);
        }
        //新循环时编译器认可而非虚拟机，编译器会将代码改为普通for循环遍历数组
        for(String str: array){
            System.out.println(str);
        }
        /*
            JDK5之后还有一个特性：泛型，它被大量的应用于集合中，用来在使用集合时
            指定集合中的元素类型
            对于基本类型而言，要指定它的包装类（比如int的包装类Integer）
         */
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        /*
            新循环遍历集合就是迭代器遍历，因此注意，不要在遍历的过程中使用
            集合的方法增删元素
         */
        for(String str: c){
            System.out.println(str);
        }
        Iterator<String> it = c.iterator();
        while (it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
    }
}
