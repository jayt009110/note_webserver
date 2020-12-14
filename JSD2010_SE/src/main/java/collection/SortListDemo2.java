package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(2,3));
        list.add(new Point(1,3));
        list.add(new Point(2,2));
        list.add(new Point(5,7));
        list.add(new Point(8,6));
        list.add(new Point(4,8));
        list.add(new Point(9,0));
        System.out.println(list);
        /*
            Collections.sort(List list)
            该方法排序集合时要求集合元素必须实现了接口:Comparable,否则编译不通过
            实现该接口就要重写比价方法从而确定同类型的对象之间的大小关系，sort方法
            就是利用自身元素提供的比较方法确定大小，进行自然排序
            对于不能直接使用这个sort方法时就不要使用了，因为它对我们的代码将产生
            侵入性，不利于程序后期的维护
         */
//        Collections.sort(list);
        Collections.sort(list,(o1,o2)->o1.getX()*o1.getX()+o1.getY()*o1.getY()-o2.getX()*o2.getX()-o2.getY()*o2.getY());
        System.out.println(list);
    }
//    class MyCompartor implements Comparator<Point>{
//        /**
//         * 该方法用来定义o1,o2的大小
//         * @param o1
//         * @param o2
//         * @return 返回值大于0时，o1>o2
//         *          返回值<0时，o1<02
//         *          返回值=0时，o1=o2
//         */
//        @Override
//        public int compare(Point o1, Point o2) {
//            int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
//            int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
//            return len1-len2;
//        }
//    }
}
