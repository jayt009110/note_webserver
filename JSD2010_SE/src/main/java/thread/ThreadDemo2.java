package thread;

/**
 * 第二种创建线程的方式
 *
 * 实现Runnable接口单独定义线程任务
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //创建线程任务
        Runnable r1 = new Runnabledemo1();
        Runnable r2 =new Runnabledemo2();

        //创建线程
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        //启动线程
        t1.start();
        t2.start();
    }
}


class Runnabledemo1 implements Runnable{
    public void run(){
        for(int i=0;i<10000;i++){
            System.out.println("跑跑啊跑啊哦安排");
        }
    }
}

class Runnabledemo2 implements Runnable{
    public void run(){
        for (int i=0;i<10000;i++){
            System.out.println("sfdafasdf");
        }
    }
}