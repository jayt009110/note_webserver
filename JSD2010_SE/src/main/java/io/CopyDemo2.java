package io;

import java.io.*;

/**
 * 使用缓冲流完成文件复制
 *
 * 缓冲字节流：java.io.BufferedInputStream和BufferedOutputStream
 * 他们是一对高级流，在流连接中的作用时加快读写字节效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("fos.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("fos1.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int input;
        long start = System.currentTimeMillis();
        /*
            缓冲流内部维护着一个8k的字节数组（默认8k，可以在创建缓冲流时自行指定其他长度）
            然后无论我们对缓冲流的读写操作时采取单字节读写还是块读写，都会被缓冲流转换为块读写来
            保证读写效率
         */
        while((input= bis.read())!=-1){
            bos.write(input);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完成,耗时"+(end-start)+"ms");
        bos.close();
        bis.close();
    }
}
