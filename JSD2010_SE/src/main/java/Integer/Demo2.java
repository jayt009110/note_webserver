package Integer;

/**
 * 包装类的常用功能
 */
public class Demo2 {
    public static void main(String[] args) {
        //数字类型的包装类定义了两个常量MAX_VALUE,MIN_VALUE表示取值范围
        int imax = Integer.MAX_VALUE;
        System.out.println(imax);

        double d = Double.MAX_VALUE;
        System.out.println(d);

        float f = Float.MAX_VALUE;
        System.out.println(f);

        /*
        包装类提供了一个静态方法parsexxx可以将字符串解析为对应的基本类型。
        前提是这个字符串正确表示了基本类型可以保存的值，否则会抛出异常；
        NumberFormatException
         */
        String line = "123";
        int i = Integer.parseInt(line);
        System.out.println(i);
        double dou = Double.parseDouble(line);
        System.out.println(dou);
    }
}
