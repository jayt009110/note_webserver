package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int start,int end)
 * 获取当前集合中指定范围内的子集
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(3,8);
        System.out.println(subList);
        for(int i=0;i<subList.size();i++){
            int j = subList.get(i)*10;
            subList.set(i,j);
        }
        /*
            对子集的任何都是对原集合对应的操作
         */
        System.out.println(list);
        System.out.println(subList);
        List<Integer> sub = list.subList(2,9);
        sub.clear();
        System.out.println(list);

    }
}
