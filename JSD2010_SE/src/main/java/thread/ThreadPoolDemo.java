package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要解决两个问题：
 * 1.重用线程
 * 2.控制线程数量
 *
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService threadpool = Executors.newFixedThreadPool(3);

        //指派任务
        for(int i=0;i<5;i++){
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread t = Thread.currentThread();
                        System.out.println(t + "正在执行任务。。。。。。");
                        Thread.sleep(5000);
                        System.out.println(t + "执行任务完毕。。。。。。");
                    }catch (Exception e){
                    }
                }
            };
            threadpool.execute(run);
            System.out.println("指派了一个任务到线程池中");
        }
//        threadpool.shutdown();
        threadpool.shutdownNow();
        System.out.println("线程停止了");
    }

}
