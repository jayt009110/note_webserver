package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合框架
 * java.util.Collection接口
 * Collection是所有集合的顶级接口，规定了所有集合的相关功能方法
 * 集合和数组一样，可以保存一组元素，但是将元素相关操作都封装成了方法，并且有多种数据结构
 * 可供选择使用
 *
 * Collection下面两个常见的子接口:
 * java.util.List:可重复有序的集合
 *               java.util.ArrayList和LinkedList是常用的List集合实现类
 * java.util.set:不可重复集合.常用HashSet
 * 这里判断元素是否重复是依靠自身equals比较结果而定.Set集合不允许存在元素有equals比较
 * 为true的情况
 *
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        /*
            boolean add(E e)
            向当前集合中添加一个元素，该元素成功添加则返回true
         */
        c.add("ad");
        c.add("dasd");
        c.add("dasddas");
        c.add("ad");
        System.out.println(c);
        /*
            int size()
            返回当前集合元素个数
         */
        int size = c.size();
        System.out.println("size:"+size);
        /*
            当且仅当c.size()为0时，c.isEmpty（）为true
         */
        System.out.println("是否为空集:"+c.isEmpty());

        c.removeAll(c);

        System.out.println(c.isEmpty());
    }
}
