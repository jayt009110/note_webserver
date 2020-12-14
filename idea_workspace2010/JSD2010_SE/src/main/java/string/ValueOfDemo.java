package string;

/**
 * String提供了一组静态的方法：valueof
 * 作用是将java中其他类型转换为字符串，比较常用于基本类型转换为字符串
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        int a = 123;
        String str0 = String.valueOf(a);
        System.out.println(a);
        System.out.println(str0);

        String b = a + "";
        System.out.println(b);
    }
}
