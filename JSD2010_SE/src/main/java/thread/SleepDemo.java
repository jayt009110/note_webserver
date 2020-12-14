package thread;

import java.util.Scanner;

/**
 * sleep阻塞
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 该方法可以让执行这个方法的看成阻塞指定毫秒
 */
public class SleepDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时间：");
        int num = sc.nextInt();
        /*
            完成倒计时程序
            程序启动后，要求用户输入一个数字，然后从该数字开始每秒递减输出
            到0时输出时间到，然后程序结束
         */
        try {
            while (true){
                System.out.println(num--);
                if(num<0){
                    System.out.println("你西内了");
                    break;
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
