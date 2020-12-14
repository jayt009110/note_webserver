package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 向文件中写入字符串
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("write.txt","rw");
        byte[] line = "劝你耗子尾汁".getBytes("UTF-8");
        raf.write(line);
        raf.write(",你不讲武德".getBytes("UTF-8"));
        raf.close();
    }
}
