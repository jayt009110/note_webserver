package thread;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

/**
 * 互斥锁
 * 使用多个sychronized锁定多个不同的代码片段，但是他们指定的同步监视器对象是同一个时
 * 这些代码片段就是互斥的.
 *
 * 互斥的代码片是不能被多个线程同时执行的
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Boo boo = new Boo();
        Thread t1 = new Thread(()->boo.methodA());
        Thread t2 = new Thread(()->boo.methodB());

        t1.start();
        t2.start();

    }
}
class Boo{
    public  void methodA(){
        synchronized(this){
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName()+":执行A方法");
                Thread.sleep(5000);
                System.out.println(t.getName()+":A方法执行完毕");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    public  void methodB(){
        synchronized(this){
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName()+":执行B方法");
                Thread.sleep(5000);
                System.out.println(t.getName()+":B方法执行完毕");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}