package socket;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    /*
        java.net.Socket 套接字
        Socket封装了TCP的通讯细节，我们使用Socket与服务器端建立连接后，只需要通过两条流
        的读写来完成与服务端的交互操作
     */
    private Socket socket;


    public Client(){
        try {

            System.out.println("正在连接服务器..");
            socket = new Socket("192.168.4.45",8088);
            System.out.println("与服务端建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void start(){
        try {
            //启动线程用于读取服务端发过来的消息
            ServerHandler serverHandler = new ServerHandler();
            Thread t = new Thread(serverHandler);
            t.setDaemon(true);
            t.start();
            /*
                Socket提供的方法：
                OutputStream getOutputStream()
                该方法会返回一个字节输出流，通过这个流写出的数据会通过网络发送给远端
                计算机
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);
            Scanner sc = new Scanner(System.in);

            while (true) {
                String line = sc.nextLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                pw.println(line);;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        client.start();
    }
    private class ServerHandler implements  Runnable{
        public void run(){
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String line;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
