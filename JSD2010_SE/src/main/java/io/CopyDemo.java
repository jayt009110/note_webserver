package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件的复制操作
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /*
            1.创建文件输入流读取源文件
            2.创建文件输出流用于写赋值文件
            3.循环从源文件读取字节并写入到复制文件中完成复制
            4.关闭两个流
            利用块读写复制
         */
        FileInputStream fis = new FileInputStream("fos.txt");
        FileOutputStream fos = new FileOutputStream("fos1.txt");
        byte[] data = new byte[5];
        int input;
        while((input= fis.read(data))!=-1){
            fos.write(data,0,input);
        }
        System.out.println("复制完成");
        fos.close();
        fis.close();

    }
}
