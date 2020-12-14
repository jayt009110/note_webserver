package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


/**
 *聊天室服务端
 */
public class Server {
    /*
        java.net.serversocket 运行在服务器端的ServerSocket相当于时"总机",只要负责：
        1：向系统申请服务端口，客户端就是通过这个端口与服务端建立连接。
        2：监听服务器端口，一旦一个客户端连接，ServerSocket就会立即创建一个Socket与之对应
           通过这个Socket就可以与客户端对等交互了。
     */
    private ServerSocket server;
//    private PrintWriter[] allOut = {};
    Collection<PrintWriter> allOut = new ArrayList<>();

    public Server(){
        try {
            System.out.println("正在启动服务器端.....");
            /*
                实例化ServerSocket可能抛出异常:
                java.net.BindException:address already in use
                遇到这个错误说明端口已被占用，请更换端口
             */
            server = new ServerSocket(8088);
            System.out.println("服务器端启动完毕.....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            /*
                ServerSocket提供的方法：
                Socket accept()
                该方法是一个阻塞方法，调用后开始等待客户端的连接，一旦一个客户端建立连接
                此时方法会立即返回一个socket，通过这个Socket实例与客户端交互。
                多次调用该方法可以接收多个客户端的连接
             */
            while(true){
                System.out.println("等待客户端连接....");

                Socket socket = server.accept();
                System.out.println("一个客户端已连接!");
                //当一个客户端连接后启动一个线程来与其进行交互
                ClientHandler clienthandler = new ClientHandler(socket);
                Thread t = new Thread(clienthandler);
                t.start();
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 这个线程的任务是负责与特定的客户端进行交互，
     * 服务端运行后，每当一个客户端连接，都会启动一个线程来执行一个这样的任务,
     */
    private class  ClientHandler implements Runnable{
        private  Socket socket;
        String host; //记录客户端的IP地址信息
        public ClientHandler(Socket socket){
            this.socket = socket;
            //通过socket获取远端计算机地址信息
            host = socket.getInetAddress().getHostAddress();
        }
        public void run(){
            PrintWriter pw = null;
            try {
                /*
                    Socket提供的方法:
                    InputStream getInputStream()
                    通过Socket获取的字节输入输入流可以读取远端计算机发送过来的字节
                */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw =  new OutputStreamWriter(out,"UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw,true);

                /*
                    将该输出流存入数组allOut中，这样其他的ClientHandler实例就可以
                    得到当前ClientHandler实例中的输出流，以便将消息转发给客户端
                 */
                // 1.对allOut扩容
                synchronized (Server.this){//锁所有ClientHandler外部类对象Server的实例
//                    allOut = Arrays.copyOf(allOut,allOut.length+1);
//                    allOut[allOut.length-1] = pw;
                    allOut.add(pw);

                }
                System.out.println(host+"上线了，当前在线人数"+allOut.size());

                String line;
                while((line = br.readLine())!=null){
                    System.out.println(host+"说:"+line);
                    //回复客户端
                    synchronized (Server.this){
//                        for (int i=0;i<allOut.size();i++){
//                            allOut.[i].println(host+"说:"+line);
//                        }
                        for(PrintWriter str:allOut){
                            str.println(host+"说:"+line);
                        }
                    }



                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                //当客户端断开连接后的操作
                //将当前客户端的输出流从allOut中删除
                synchronized (Server.this){
//                    for(int i=0;i<allOut.length;i++){
//                        if(allOut[i]==pw){
//                            allOut[i] = allOut[allOut.length-1];
//                            allOut = Arrays.copyOf(allOut,allOut.length-1);
//                            break;
//                        }
//                    }
//                    for(PrintWriter str:allOut){
//                        if(pw.equals(str)){
//                            allOut.remove(str);
//                            break;
//                        }
//                    }
                    allOut.remove(pw);
                }

                System.out.println(host+"下线了，客户端在线人数:"+allOut.size());
                try {
                    socket.close();  //与客户端断开连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
