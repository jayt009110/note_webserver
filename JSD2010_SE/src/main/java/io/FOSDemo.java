package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java IO 标准的输入输出流
 * java IO将读写功能按照方向划分为输出与输入
 * 输入流：用于读写数据的流，是从外界到程序中的方向
 * 输出流：用于写出数据的流
 * java.io.InputStream和OutputStream是所有字节输入输出流的超类，规定了相关的
 * 读写字节的方法
 *
 * java将流归纳为两类：
 * 节点流:又称为低级流，是真实连接程序与另一端的“管道”，负责实际搬运数据的流，读写一定是建立在节点流
 * 的基础上进行的
 * 处理流：不能单独存在，必须建立在其它流之上，目的是当数据“流经”当前流时对其进行某种加工处理
 * 来简化读写数据的操作
 *
 * 文件流：java.io.FileOutputStream
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
            使用文件输出流输出字节

            FileOutputStream常用的构造器：
            FileOutputStream(String path)
            FileOutputStream(File file)
            以上两种构造器创建的文件输出流为覆盖写模式，即：若指定文件存在，会将该文件数据
            全部删除，然后再将所有通过当前流写出的数据写入到文件中

            FileOutputStream(String path,boolean append)
            FileOutputStream(File file,boolean append)
            表示可以进行追加写操作，这样之前写入的数据就不会被覆盖了
         */
        FileOutputStream stream = new FileOutputStream("fos.txt",true);
        /*
            raf是随机读写形式，即:可以操作指针对文件任意位置进行写操作，FOS是顺序读写
            要么清除后重写，要么都保留从末尾追加写
         */
//        RandomAccessFile stream = new RandomAccessFile("fos.txt","rw");
//        String str = "爱喝酒啊啊哈哈哈哈哈哈哈哈，sdadasda";
//        byte[] data = str.getBytes("UTF-8");
        String str = "123";
        byte[] data = str.getBytes("UTF-8");
        stream.write(data);
        System.out.println("写出完毕");
        stream.close();
    }
}
