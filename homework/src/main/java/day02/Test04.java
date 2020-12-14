package day02;
/**
 * 执行程序，分析并解决问题
 *
 * NumberFormatException出现的情况通常是由包装类将字符串解析为基本类型时,由于字符串内容不能正确描述基本类型导致该异常.
 * 数字    格式      异常
 *
 *
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) {
        /*
         * 原因:字符串有一个空白字符，所以num字符串无法正确描述基本类型
         */
        String num = "123";
        int d = Integer.parseInt(num);
        System.out.println(d);

        /*
         * 原因:该字符串是一个小数，应该使用Double.parseDouble()将该字符串转换为Double类型。
         */
        String num1 = "123.456";
        double d1 = Integer.parseInt(num1);
        System.out.println(d1);

        /*
         * 原因:未定义对象类型，;为中文符号，应使用英文
         */
		String num2 = "123";
		int d3 = Integer.parseInt(num2);
		System.out.println(d3);
    }
}
