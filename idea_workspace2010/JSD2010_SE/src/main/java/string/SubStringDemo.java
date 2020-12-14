package string;

/**
 * String subsring(int start,int end)
 * 截取当前字符串那种指定该范围内的子字符串，两个参数为范围对应的下标。
 * 注：在JAVA API中，通常使用该两个数字表示范围时，含头不含尾
 */
public class SubStringDemo {
    public static void main(String[] args) {
        String str = "www.baidu.com";
        String sub = str.substring(4,9);
        System.out.println(sub);
        String sub1 = str.substring(4);
        System.out.println(sub1);
    }
}
