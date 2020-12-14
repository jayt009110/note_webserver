package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 显示所有用户信息
 */
public class ShowAllUserDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("inf.dat","rw");
        for(int i=0;i<raf.length()/100;i++){
            byte[] data = new byte[32];
            raf.read(data);
            String uname = new String(data,"UTF-8").trim();
            raf.read(data);
            String pwd = new String(data,"UTF-8").trim();
            raf.read(data);
            String nickname = new String(data,"UTF-8").trim();
            int age = raf.readInt();
            System.out.println(uname+","+pwd+","+nickname+","+age);
        }
        raf.close();
    }
}
