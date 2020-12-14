package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Copydemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile src = new RandomAccessFile("image.jpg","r");
        RandomAccessFile desc = new RandomAccessFile("image_cp.jpg","rw");
        int d;
        long start = System.currentTimeMillis();
        while((d=src.read())!=-1){
            desc.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start)+"ms");
        src.close();
        desc.close();
    }
}
