package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 用户注册
 * 用户信息包含四项：用户名，密码，年龄，昵称，年龄
 * 用户名，密码，昵称为字符串，年龄为int
 *
 * 每条记录占用100字节，其中用户名，密码，昵称各占32字节，年龄4字节
 * 字符串故意留白可以保证格式统一，便于修改和读取。
 */
public class RegDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎注册");
        System.out.println("请输入用户名:");
        String uname = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        System.out.println("请输入昵称:");
        String nickname = sc.nextLine();
        System.out.println("请输入年龄:");
        int age = sc.nextInt();

        RandomAccessFile raf = new RandomAccessFile("inf.dat","rw");
        raf.seek(raf.length());

        byte[] data = uname.getBytes("UTF-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);

        data = pwd.getBytes("UTF-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);


        data = nickname.getBytes("UTF-8");
        data = Arrays.copyOf(data,32);
        raf.write(data);

        raf.writeInt(age);

        System.out.println("注册完毕");
        raf.close();
    }
}
