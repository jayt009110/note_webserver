package thread;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;
import string.TrimDemo;

/**
 * 多线程
 *
 * 线程:一个单一的顺序执行流程。
 * 多线程:多个线程同时运行
 *
 * 线程有两种创建方式，第一种：
 * 继承Thread并重写run方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread  t1 = new MyThread1();
        Thread t2 = new MyThread2();
        t1.start();
        t2.start();
        /*
            启动线程要调用start方法，调用后线程会纳入到线程调度器中统一调度，
            一旦该线程第一次获取cpu的时间就会自动执行run方法，
            注意：不能主动调用run方法.
         */
    }
}

/**
 * s第一种创建线程的方式优点是结构简单，便于使用匿名内部类创建
 *
 * 但是也存在着缺点:
 * 1：由于java是单继承的，这会导致如果继承了Thread旧无法再继承其他类，通常我们继承某个类
 *    的目的是复用方法，此时如果两者希望同时满足时会出现继承冲突的问题（不能同时继承Thread
 *    和其他类）
 * 2：定义线程的同时来重写run方法来定义线程的任务，这会导致线程与线程的任务绑定在一起
 *    不利于线程复用.
 */

class MyThread1 extends Thread{
    public void run(){
        for(int i=0;i<10000;i++){
            System.out.println("你好，大撒比");
        }
    }
}
class  MyThread2  extends Thread{
    public void run(){
        for (int i=0;i<10000;i++){
            System.out.println("你凑不要脸");
        }
    }
}