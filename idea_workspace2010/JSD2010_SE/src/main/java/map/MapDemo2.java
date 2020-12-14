package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的遍历
 * Map提供了三种遍历方式：
 * 1.遍历所有的key
 * 2.遍历每一组键值对
 * 3.遍历所有的value（相对不常用）
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 97);
        map.put("数学", 8);
        map.put("物理", 5);
        map.put("外语", 92);
        map.put("化学", 95);
        System.out.println(map);

        /*
            遍历所有的key
            Set keySet()
            将当前Map中所有的key可以以一个set集合形式返回
         */
        Set<String> key = map.keySet();
        for (String str : key) {
            System.out.println("key:" + str);
        }

        /*
           遍历每组键值对
           Set<Entry> entrySet()
           将当前Map中每一组键值对（一个Entry实例）存入一个Set集合后返回
           java.util.Map.Entry的每一个实例表示Map中的一组键值对
         */
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> e : entrySet) {
            String key1 = e.getKey();
            Integer value1 = e.getValue();
            System.out.println(key1 + ":" + value1);
        }

        Collection<Integer> values = map.values();
        for(Integer i:values){
            System.out.println("value:"+i);
        }
    }
}
