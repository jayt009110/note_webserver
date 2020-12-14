package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过每次读写的数据量，减少读写次数可以提高读写效率
 * 单字节读写时随机读写形式
 * 一组字节读写是块读写
 * 使用块读写方式明显性能高于随机读写
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile src = new RandomAccessFile("image1.jpg","r");
        RandomAccessFile desc = new RandomAccessFile("image_cp1.jpg","rw");
        /*
            int read(byte[] data)
            一次性从文件中读取给定的字节数组总长度的字节量，并存入到该数组中，返回值为
            实际读取到的字节量，返回值为-1则表示EOF
             int d = src.read(data);//连续读取4个字节并存入到data数组中
         */
        byte[] data = new byte[5];
        int d;
        long start = System.currentTimeMillis();
        while((d=src.read(data))!=-1){
            desc.write(data,0,d);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start)+"ms");
        src.close();
        desc.close();
    }
    }

