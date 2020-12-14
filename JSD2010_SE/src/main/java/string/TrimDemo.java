package string;

/**
 * String trim()
 * 去字符串两边的空白字符
 */
public class TrimDemo {
    public static void main(String[] args) {
        String line = "    hello            ";
        String str = line.trim();
        System.out.println(line);
        System.out.println(str);
        System.out.println(line.length());
        System.out.println(str.length());
    }

}
