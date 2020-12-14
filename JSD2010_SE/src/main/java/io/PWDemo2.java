package io;

import java.io.*;

/**
 * 在流连接中使用PW
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("pw2.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);

        pw.print("在那深夜酒吧");
        pw.print("哪管他是真是");
        System.out.println("写入完毕");

        pw.close();
    }
}
