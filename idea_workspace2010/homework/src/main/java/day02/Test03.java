package day02;

import java.util.Scanner;

/**
 * 执行程序，分析并解决问题
 * @author Xiloer
 *
 */
public class Test03 {
    public static void main(String[] args) {
        String path1 = "/myweb/reg";//处理注册的路径
        String path2 = "/myweb/login";//处理登录的路径
        /*
         * 程序启动后，输入上述两个地址后检查下面输出.
         * 分析并解决存在的问题，并写出错误原因:
         *
         *问题：path对象存储的是地址，地址无法与字符串直接进行比较
         * 解决方法：调用equals方法可以获取path的字符串，这样就可以进行字符串之间的比较
         *
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入地址:");
        String path = scanner.nextLine();
        if(path!=null) {
            if(path.equals(path1)) {
                System.out.println("处理注册!");
            }else if(path.equals(path2)) {
                System.out.println("处理登录!");
            }else {
                System.out.println("输入地址有误!");
            }
        }
    }
}
