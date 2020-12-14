package thread;

/**
 * 静态方法上若使用synchronized，那么该方法一定具有同步效果
 * 静态方法指定的同步监视器对象为当前类的类对象，后面学习反射的知识时会介绍类对象
 */
public class SyncDemo3 {
    public static void main(String[] args) {
//        Foo f1 = new Foo();
//        Foo f2 = new Foo();

        Thread t1 = new Thread(()->Foo.dosome());
        Thread t2 = new Thread(()->Foo.dosome());
//        Thread t1 = new Thread(()->f1.dosome());
//        Thread t2 = new Thread(()->f2.dosome());

        t1.start();
        t2.start();
    }
}
class Foo{
//    public synchronized static void dosome(){
        /*
            静态方法中如果使用同步块，那么指定的同步监视器对象就是当前类的类对象即可
            获取类对象可以直接用:类名.class
         */
    public static void dosome(){
        synchronized (Foo.class){
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+";正在执行dosome方法");
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(t.getName()+":dosome方法执行完毕");
        }

    }
}