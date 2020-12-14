package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输入流，用于读取数据
 *
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        byte[] data = new byte[1000];
        int len = fis.read(data);
        System.out.println("读到了"+len+"个字节");
        String str = new String(data,0,len,"UTF-8");
        System.out.println(str);
        System.out.println(str.length());
        fis.close();
    }
}
