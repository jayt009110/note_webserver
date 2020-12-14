package thread;

/**
 * sleep方法要求我们处理中断异常
 * 每一个线程调用该方法处于睡眠阻塞的过程中，它的interrupu()方法被调用，那么此时会中断
 * 它的睡眠阻塞，这时sleep方法会抛出中断异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
          public void run(){
              System.out.println("睡觉");
              try {
                  Thread.sleep(10000);
              } catch (InterruptedException e) {
                  System.out.println("你要干神魔，脸都破相了");
              }
              System.out.println("醒了");
          }
        };
        Thread huang = new Thread(){
            public void run(){
                System.out.println("大锤80！小锤40！");
                for (int i=0;i<5;i++){
                    System.out.println("80!40!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("哐当！");
                System.out.println("收工了");
                lin.interrupt();

            }
        };
        lin.start();
        huang.start();
    }
}
