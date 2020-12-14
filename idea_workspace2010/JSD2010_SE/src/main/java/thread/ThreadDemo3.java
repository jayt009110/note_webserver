package thread;

/**
 * 使用匿名内部类
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
//
      Runnable r1 =new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i < 1000; i++) {
                  System.out.println("那就");
              }
          }


      };
      Thread t2 = new Thread(()->{
          for(int i=0;i<1000;i++){
              System.out.println("dasdasda");
          }
      });
      Thread t1 = new Thread(r1);
      t1.start();
      t2.start();

    }
}

