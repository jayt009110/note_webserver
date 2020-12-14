package thread;

/**
 * 同步块
 * 语法：
 * synchronized(同步监视器对象){
 *     需要多线程同步执行的代码片段
 * }
 *
 * 同步块可以更准确的锁定需要排队的代码片段，有效的缩小同步范围可以在保证安全的前提下
 * 提高并发效率。
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread(){
            public void run(){
                shop.buy();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}
class Shop{
    /*
        在方法上使用synchronized，那么同步监视器是不可选的，就是this
     */
//    public synchronized void buy()
    public void buy(){
        try{
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":进店挑衣服");
            Thread.sleep(5000);
            /*
                使用同步块时需要指定同步监听对象，这个对象可以是java中任何类的实例
                只要保证多个需要排队执行的该同步块的多个线程看到的这个对象是同一个即可
             */
            synchronized (this){
                System.out.println(t.getName()+":去换衣间试衣服");
                System.out.println(t.getName()+":衣服换好了，出来了");
                Thread.sleep(5000);

            }


            System.out.println(t.getName()+":结账离开");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}