package object;

/**
 * 测试Object中的常用方法
 */
public class Demo {
    public static void main(String[] args) {
        Point point = new Point(3,4);
//        String str = point.toString();
        /*
        Object类定义的方法：
        String toString()
        该方法是将当前对象转换为一个字符串，默认返回的是当前对象的地址信息
        格式为：类名@地址
         */
//        System.out.println(str);
        /*
        System.out.println(Object o)
        该方法是将给定对象toString方法的返回值输出到控制台
        子类不重写toString,对输出内容帮助不大
         */
        System.out.println(point);
        /*
        任何内容与字符串连接，结果都是字符串
        当字符串与其他类型连接时，会将该引用类型的toString方法的返回值进行连接
         */
        String line = "point:" + point;
        System.out.println(line);
        /*
        Object定义的另一个常用方法：
        boolean equals（Object o）
        用来比较当前对象（this）与给定对象o内容是否相同。
        注意！如果子类不重写这个方法则没有实际价值，因为Object时使用==比较的
         */
        Point point1 = new Point(3,4);
        System.out.println(point==point1);
        System.out.println(point.equals(point1));
    }
}
