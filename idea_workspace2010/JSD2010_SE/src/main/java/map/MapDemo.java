package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map 查找表
 * Map体现的结构是一个多行两列的表格，其中左列称为key,右列称为value
 * Map总是根据key的值获取它对应的value的值
 *
 * Map是一个接口，规定了Map的相关操作方法
 * 常用实现类:java.util.HashMap,俗称:散列表，哈希表
 * HashMap是使用散列算法实现的Map,当今查询速度最快的数据结构
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        /*
            V put(K k,V v)
            将一组键值对存入到Map中
            Map要求key不允许重复，如果使用重复的key存入value,则是替换value操作
            那么返回值就是被替换掉的value，否则返回值为null
         */
        Integer value = map.put("语文",98);
        System.out.println("value:"+value);
        map.put("数学",97);
        map.put("英语",6);
        map.put("物理",95);
        map.put("化学",75);
        map.put("地理",8);
        System.out.println(map);

        value = map.put("语文",77);
        System.out.println(map);
        System.out.println("value:"+value);

        /*
            V get(Object key)
            根据给定的key获取对应的value，如果给定的key不存在则返回值为null
         */
        value = map.get("数学");
        System.out.println("数学:"+value);
        value = map.get("体育");
        System.out.println("体育："+value);

        int size = map.size();
        System.out.println("size:"+size);

        /*
            V remove(Object key)
            删除给定的key所对应的键值对，返回值为这个key所对应的value
            没有这个key则返回null,原map无任何变化
         */
        map.remove("数学");
        System.out.println(map);

    }
}
