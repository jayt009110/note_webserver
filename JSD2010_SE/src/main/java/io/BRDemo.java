package io;

import java.io.*;

/**
 * 缓冲字符输入流
 * 特点：可以按行读取字符串
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        /*
            String readLine()
            读取一行字符串，返回的字符串那种不带有最后的换行符，如果当前行时空行（只有一个换行符）
            那么返回的字符串是空字符串，当流读取到末尾时，返回值为null.
         */
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }

}
