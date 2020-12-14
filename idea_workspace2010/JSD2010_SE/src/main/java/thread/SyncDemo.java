package thread;

/**
 * 多线程并发安全问题
 * 当多个安全并发操作同一临界资源，由于线程切换实际不确定，导致操作顺序出现混乱并影响
 * 操作结果，严重时可能导致系统瘫痪
 *
 * 临界资源:操作该资源的完整过程同一时间只能被一个线程进行的
 */
public class SyncDemo {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread(){
            public void run(){
                while (true){
                    int bean = table.getBeans();

                    Thread.yield();

                    System.out.println(getName()+":"+bean);
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    int bean = table.getBeans();

                    Thread.yield();

                    System.out.println(getName()+":"+bean);
                }

            }
        };
        t1.start();
        t2.start();
    }
}
class Table{
    private int beans = 20;

    /**
     * 当一个方法使用关键字:synchronized修饰后，这个方法称为同步方法，多个线程不能同时在
     * 该方法内部同时执行，将异步操作临界资源改为同步操作可以解决多线程并发安全问题
     *
     */
    public synchronized int getBeans(){
        if(beans==0){
            throw new RuntimeException("没豆子了");
        }
        Thread.yield();
        return beans--;
    }
}
