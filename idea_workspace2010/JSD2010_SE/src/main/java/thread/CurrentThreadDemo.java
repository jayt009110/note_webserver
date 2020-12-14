package thread;

/**
 * java中所有的代码都是靠线程运行的，单独看每条线程的执行方式仍然是顺序执行，但是多个线程
 * 之间是并发运行的（感觉上是同时运行的）
 *
 * main方法也是靠一条线程运行的，通常被称为“主线程”
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t0 = Thread.currentThread();
        System.out.println("当前运行的主线程是:"+t0);
        Thread t1 = new Thread(){
            public void run(){
                Thread t = Thread.currentThread();
                System.out.println("当前运行的线程是:"+t);
                dosome();
                System.out.println(t+"线程执行完毕");
            }
        };
        t1.start();

        dosome();
        System.out.println(t0+"执行完毕 ");

    }
    public static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println("当前运行的线程是:"+t);
    }
}
