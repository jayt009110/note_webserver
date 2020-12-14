package raf;

import java.io.*;
import java.util.Scanner;

/**
 * 编写一个简易记事本工具
 * 程序启动后要求输入一个文件名，然后对文件进行写操作
 * 之后用户输入的每一行内容都要写入文件中（不考虑换行）
 * 当用户单独输入exit时，退出；
 */
public class Note {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要创建的文件名:");
        String filename = scanner.nextLine();
        String exit = "exit";
//        File file = new File(filename);
        RandomAccessFile raf = new RandomAccessFile(filename,"rw");
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("输入写入内容：");
            String str = sc.nextLine();
            if(str.toUpperCase().equals(exit.toUpperCase())){
                System.out.println("输入完毕");
                raf.close();
                break;
            }

            byte[] line =str.getBytes("UTF-8");
            raf.write(line);

        }

    }
}
