package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合提供的工具类：java.util.Collections里面定义了很多静态方法，便于我们操作集合
 * 其中的静态方法sort可以对List集合进行自然排序(从小到大)
 */
public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<10;i++){
            int num = rand.nextInt(100);
            list.add(num);
        }
        System.out.println("list:"+list);
        Collections.sort(list);
        System.out.println("list:"+list);
        Collections.sort(list,(o1, o2) ->o2-o1 );
        System.out.println("list:"+list);

    }
}
