package thread;

/**
 * join方法可以协调线程之间的同步运行。
 *
 * 同步运行和异步运行时多线程执行的两种方式
 *
 * 同步运行：线程之间存在先后顺序，有序进行
 * 异步运行：线程之间各干各的。
 * 多线程运行本身就是异步运行的，但是在某些业务中我们需要协调线程之间的同步运行，此时
 * 就可以使用join来完成
 */
public class JoinDemo {
    static boolean isFinish = false;
    /*
        java有一个语法要求:当一个方法的局部内部类使用到了这个方法中的其他局部变量的时候
        ，这个变量必须是final的（JDK8之后，可以不声明为final，但是仍然是final的）
     */
    public static void main(String[] args) {
//        boolean isFinish = false;
        Thread download = new Thread(){
            public void run(){
                System.out.println("开始下载图片");
                for (int i=0;i<=100;i++){
                    System.out.println("下载进度:"+i+"%");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("dowm:图片下载完成");
                isFinish = true;
            }
        };
        Thread content = new Thread(){
          public void run(){
              System.out.println("开始显示文字");
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("文字加载完毕");

              //这里在显示图片前，应当等待download线程执行完毕
              System.out.println("等待download结束");
              try {
                  download.join();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("download结束");

              if(!isFinish){
                  throw new RuntimeException("图片加载失败");
              }
              System.out.println("图片显示完毕");
          }
        };
        download.start();
        content.start();
    }
}
