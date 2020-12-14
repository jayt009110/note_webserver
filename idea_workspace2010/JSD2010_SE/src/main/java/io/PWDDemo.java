package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字节流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流内部维护一个缓冲区，可以块读写文本数据以加快读写效率
 * 并且缓冲流还可以按行读写字符串
 *
 * java.io.PrintWriter具有自动行刷新的缓冲字符输出流，内部从事连接BufferedWriter作为缓冲功能
 */
public class PWDDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        /*
            PW提供了直接对文件做写操作的构造器
            PrintWriter(String path)
            PrintWriter(File file)
            以上两种构造器还提供了重载，允许再传入一个String类型参数来指定字符表
         */
        PrintWriter pw = new PrintWriter("pw.txt","UTF-8");
        pw.println("你是那天边最美的云彩，");
        pw.println("我们用心把你留下来");
        System.out.println("写入完毕");
        pw.close();

    }
}
