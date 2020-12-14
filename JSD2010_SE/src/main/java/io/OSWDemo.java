package io;

import java.io.*;

/**
 * 字符流
 *
 * java将流按照读写单位划分为字节流与字符流.
 * java.io.InputStream和OutputStream时所有字节输入输出流的超类
 * java.io.reader和writer时所有字符输入输出流的超类
 * 字符流的最小读写单位为字符(char)，但是底层实际还是读写字节，只不过字符与字节的转换由
 * 字符流自动完成
 *
 * 转换流:java.io.InputStreamReader和OutputStreamWriter
 * 他们是常用的一对字符流实现类，并且是一对高级流实际开发中我们并不直接使用它们，
 * 但是他们在流连接中时非常重要的一环
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");

        /*
            转换流的中的输出流的主要工作就时将写出的字符串按照指定的字符集准换为字符
            然后再将转换后的字节交给它连接的字节流写出
         */
        osw.write("夜空中最亮的星");
        osw.write(",不知道是什么");

        osw.close();
    }
}
