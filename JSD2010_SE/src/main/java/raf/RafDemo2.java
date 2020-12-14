package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 从文件中读取字节
 */
public class RafDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("raf.dat","r");
        for(int i=0;i<303;i++){

            System.out.println(raf.read());
        }
        raf.close();
    }
}
