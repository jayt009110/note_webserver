package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 完成一个转码工具。
 * 比如当前项目目录下有一个文本文件note.txt，字符串编码
 * 是GBK的，现在需要将这个文件内容转换为UTF-8编码，并将其
 * 写出到文件note_utf.txt中。
 *
 * 单词记一记：
 * note 笔记
 *
 * 思路:
 * 用GBK编码将note.txt文件内容读取出来，再以UTF-8编码写入
 * 到note_utf.txt中
 *
 * 要点:
 * 组建流连接时，输入流中的转换流指定为GBK编码。最终用缓冲
 * 输入流按行读取字符串。
 * 组件输出流中的转换流时指定为UTF-8编码，最终按行写出时
 * 就可以了。
 *
 *
 * 最终程序可以扩展为，读取的文件名可以让用户在控制台输入，
 * 该文件的字符集也可以指定。然后想转换为什么字符集也可以
 * 指定，并最终写入一个新文件。这样就可以随意使用了。
 *
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入文件名：");
        String filename = sc.nextLine();
        System.out.println("输入初始编码字符集:");
        String icode_set = sc.nextLine();
        System.out.println("输入编码字符集:");
        String code_set = sc.nextLine();
        String[] filename1 = filename.split(".");

        try (FileInputStream fis = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(fis, icode_set.toUpperCase());
             BufferedReader br = new BufferedReader(isr);

             FileOutputStream fos = new FileOutputStream(filename1[0]+code_set.toLowerCase()+filename1[1]);
             OutputStreamWriter osw = new OutputStreamWriter(fos, code_set.toUpperCase());
             BufferedWriter bw = new BufferedWriter(osw);
             PrintWriter pw = new PrintWriter(bw);
        ) {
            int d;
            while ((d = br.read()) != -1) {
                pw.println((char)d);
            }

        }catch(Exception e){
            System.out.println("出错了");
        }
    }
}