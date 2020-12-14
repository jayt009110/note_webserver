package string;

/**
 * String的优化导致了他必须是不变对象，然而这非常不利于修改内容——性能差，开销大
 * 为了解决这个问题，java提供了一个专门用来修改字符串内容的api：StringBuilder
 * StringBuilder内部维护一个可变的char数组，修改内容时开销小，速度快，并且提供了修改字符串
 * 内容相关的操作：增删改插，以及String中操作字符串的常用方法（length,indexof等等）
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String str = "21123asda";
        StringBuilder sb = new StringBuilder(str);
        sb.append(",123");
        String s = sb.toString();
        System.out.println(s);

        sb.replace(4,7,"fghgfg");
        System.out.println(sb.toString());

        sb.delete(3,6);
        System.out.println(sb.toString());
        System.out.println(sb);

        sb.insert(0,"llf,");
        System.out.println(sb);
    }
}
