package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF读写基本类型数据，以及基于指针的操作
 */
public class RAFDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("rat.txt","rw");
        long pos = raf.getFilePointer();
        System.out.println("position:"+pos);


        int imax = Integer.MAX_VALUE;
        raf.write(imax>>>24);
        System.out.println("position:"+raf.getFilePointer());
        raf.write(imax>>>16);
        System.out.println("position:"+raf.getFilePointer());
        raf.write(imax>>>8);
        System.out.println("position:"+raf.getFilePointer());
        raf.write(imax);
        System.out.println("position:"+raf.getFilePointer());
        raf.writeDouble(123.32);
        System.out.println("position:"+raf.getFilePointer());
        System.out.println("写入完毕");


        raf.seek(0);
        int d = raf.readInt();
        System.out.println(d);
        System.out.println("position:"+raf.getFilePointer());
        double dou = raf.readDouble();
        System.out.println(dou);
        System.out.println("position:"+raf.getFilePointer());

        raf.seek(4);
        raf.writeDouble(333.456);
        double dou1 = raf.readDouble();
        System.out.println(dou1);
        raf.close();
    }
}
