package string;

/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 判断当前字符串是否时以给定的内容开始或结束
 */
public class StartWithDemo {
    public static void main(String[] args) {
        String line = "www.baidu.com";
        boolean l = line.startsWith("www");
        boolean l1 = line.startsWith("http");
        boolean li = line.endsWith("com");
        boolean li1 = line.endsWith("cn");
        System.out.println(l);
        System.out.println(l1);
        System.out.println(li);
        System.out.println(li1);
    }
}
