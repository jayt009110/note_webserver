package io;

import java.io.*;
import java.util.Scanner;

public class Note3 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String filename = sc.nextLine();
        String exit = "exit";

        boolean iswrite = false;
        //将外层while循环取名为out
        out:while(true) {
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("请更换一个文件名:");
                filename = sc.nextLine();
                continue;
            }
            FileOutputStream fos = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            /*
                PrintWriter创建时，如果第一个参数是一个流，则支持第二个参数——autoFlush
                该值为true则当前pw具有自动行刷新功能，即：调用一次println会自动刷新
                    注意：调用print方法后并不会刷新！
             */
            PrintWriter pw = new PrintWriter(bw,true);
            while (true) {
                System.out.println("请输入内容:");
                String note = sc.nextLine();
                if (note.equalsIgnoreCase(exit)) {
                    System.out.println("退出");
                    pw.close();
                    break out; //直接打断out:while()外层循环
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
