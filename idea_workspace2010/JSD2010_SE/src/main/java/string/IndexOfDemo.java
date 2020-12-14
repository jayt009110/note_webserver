package string;

/**
 * int indexof(String str)
 * 判断当前字符串中给定字符串的所在位置，如果当前字符串不包含给定内容时返回值为-1
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        String str = "things are cheap in market";
        int index = str.indexOf("e");
        System.out.println(index);
        int index1 = str.indexOf("e",10);
        System.out.println(index1);
        int index2 = str.lastIndexOf("e");
        System.out.println(index2);
    }
}
