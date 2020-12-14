package day01;

import java.util.Scanner;

/**
 * 改正下面代码的错误
 *
 * 代码要实现的功能:要求用户输入一个网址，格式如:
 * www.baidu.com
 * 然后判断根据域名判断是百度(baidu)或者达内(tedu)或其他
 * 然后输出判断结果
 *
 * 单词记一记:
 * start 开始
 * end 结束
 *
 * 解决问题后，记录下来遇到的问题，以及解决办法
 *
 * @author Xiloer
 *
 */
public class Test05 {
    /*
    问题记录：
    1.首先时截取字符串的起始位置和结束位置的取值问题，起始位置应该时第一个.的位置下标+1，
    结束位置应该是第二个.的下标。因为截取字符串的方法，其取值是含头不含尾
    2.字符串之间的比较不能用对象与字符串直接比较，因为对象存储的式地址，地址与字符串的值是两个概念，
    应该使用equals方法来比较字符串的值，在此之前声明a,b两个变量储存需要比较的字符串的值。
     */
    public static void main(String[] args) {
        System.out.println("请输入一个网址:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String a = "baidu";
        String b = "tedu";
        //截取域名
        int start = line.indexOf(".");
        int end = line.indexOf(".",start+1);
        String name = line.substring(start+1,end);
        //判断域名是否为baidu
        if(name.equals(a)) {
            System.out.println("这是百度网站");
        //判断域名是否为tedu
        }else if(name.equals(b)) {
            System.out.println("这是达内网站");
        }else {
            System.out.println("这是其他网站");}

    }
}
