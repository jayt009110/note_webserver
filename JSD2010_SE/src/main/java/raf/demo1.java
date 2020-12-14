package raf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFIle
 * RAF专门用来读写文件的API，其基于指针对文件任意位置可进行读或写操作。
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        /*
            对当前目录下的raf.dat文件写操作

            RandomAccessFile常用的构造方法
            RandomAccessFile(String path,String mode)
            RandomAccessFile(File file,String mode)
            第一个参数是传入要操作的文件，可以传路径或者一个File对象
            第二个参数时操作模式，支持：“r”只读模式，“rw”读写模式
         */
        File file = new File("./raf.dat");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        for(int i=0;i<300;i++){
            raf.write(i);
        }
        raf.close();
        System.out.println("写入完毕");
    }
}
