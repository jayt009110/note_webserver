package thread;

/**
 * 线程 一套获取信息的方法
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        //获取当前线程的名字
        String name = main.getName();
        System.out.println("name:"+name);

        //唯一标识
        long id = main.getId();
        System.out.println("id:"+id);

        //获取线程优先级，默认5,1-10
        int priority = main.getPriority();
        System.out.println("优先级:"+priority);

        //线程是否存活
        boolean isAlive = main.isAlive();
        //是否是守护线程
        boolean isDaemon = main.isDaemon();
        //线程是否被中断
        boolean isInterrupted = main.isInterrupted();
        System.out.println(isAlive+","+isDaemon+","+isInterrupted);

    }
}
