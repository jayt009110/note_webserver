package io;

import java.io.*;
import java.util.Scanner;

/**
 * 编写一个简易记事本
 * 程序启动后要求用户输入一个文件名，然后对文件进行写操作
 * 之后用户输入每一行的内容都要写入文件中（不考虑换行）
 * 用户单独输入exit时退出
 */
public class Note {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String filename = sc.nextLine();
        String exit = "exit";
        FileOutputStream fos = new FileOutputStream(filename,true);
//        FileInputStream fis = new FileInputStream(filename);
        byte[] data = new byte[1024];
        System.out.println("请输入内容：");

        while(true){
            String note = sc.nextLine();
            if(note.equalsIgnoreCase(exit)){
                System.out.println("退出");
                break;
            }
            fos.write(note.getBytes("UTF-8"));
        }
        System.out.println("写入完毕");
        fos.close();


    }
}
