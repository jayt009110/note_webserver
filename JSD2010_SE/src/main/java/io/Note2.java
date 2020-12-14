package io;

import java.io.*;
import java.util.Scanner;

/**
 * 编写一个简易记事本
 * 程序启动后要求用户输入一个文件名，然后对文件进行写操作
 * 若文件名存在则换一个名字，不存在则继续写入内容
 * 之后用户输入每一行的内容都要写入文件中
 * 用户单独输入exit时退出
 */
public class Note2 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String filename = sc.nextLine();
        String exit = "exit";

        boolean iswrite = false;
        while(!iswrite) {
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("请更换一个文件名:");
                filename = sc.nextLine();
                continue;
            }
            FileOutputStream fos = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw);
            while (true) {
                System.out.println("请输入内容:");
                String note = sc.nextLine();
                if (note.equalsIgnoreCase(exit)) {
                    System.out.println("退出");
                    pw.close();
                    break;
                } else {
                    pw.println(note);
                    iswrite = true;
                }
            }
        }
        if(iswrite){
            System.out.println("写出完毕");
        }


    }
}
