package string;

/**
 * String支持正则表达式方法三：
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为指定内容
 */
public class ReplaceDemo {
    public static void main(String[] args) {
        String str = "213sdsf12312fdsf";
        str = str.replaceAll("[a-zA-Z]+","@@@@@");
        System.out.println(str);
        str = str.replaceAll("[0-9]+","******");
        System.out.println(str);
        String regex = "(nmb|wdnmd|snz|cnm|gnmd|qnmd|cnmd)";
        String message = "nmb!我wdnmd";
        message = message.replaceAll(regex,"***");
        System.out.println(message);
    }
}
