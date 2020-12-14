package Integer;

/**
 * 包装类
 * java为了解决基本类型不能直接参与面向对象开发而为他们提供了对应的引用类型，称为包装类
 * 并且8个包装类都处在java.lang包中
 * 包装类就是以“对象”的形式表示基本类型数据。
 */
public class Demo1 {
    public static void main(String[] args) {
        int d = 123;
        double doub = 123.123;
        float f = 123.1f;
//        Integer i1 = new Integer(d);
//        Integer i2 = new Integer(d);
        /*
         java推荐使用包装类的静态方法valueOf创建包装类。
         Integer在使用valueOf形式创建对象时会重用-128 - 127之间的整数对象，减少内存开销
         */
        Integer i1 = Integer.valueOf(d);
        Integer i2 = Integer.valueOf(d);
        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));
        Float f1 = Float.valueOf(f);
        Double doub1 = Double.valueOf(doub);
        System.out.println(f1);
        System.out.println(doub1);

        int n = f1.intValue();
        double d1 = doub1.floatValue();
        short i4 = i1.shortValue();
    }
}
