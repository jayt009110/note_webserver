package thread;

/**
 * 守护线程
 * 守护线程通过普通线程调用setDaemon（true）设置而来，因此创建和使用与普通线程无区别
 * 但是有一点是不同的：进程的结束
 *
 * java进程结束：当该进程中所有的普通线程都结束时，java进程就会结束（jvm结束），此时
 * 会强制杀死所有正在运行的守护进程
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for (int i=0;i<10;i++){
                    System.out.println("rose:I wanna to go die");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("噗通！西内了");
            }
        };
        Thread jack = new Thread(){
            public void run(){
                while (true){
                    System.out.println("you jump!I junmp!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        rose.start();
        /*
            设置守护线程必须在线程启动前进行
         */
        jack.setDaemon(true);
        jack.start();
        System.out.println("main方法执行完了");
    }
}
