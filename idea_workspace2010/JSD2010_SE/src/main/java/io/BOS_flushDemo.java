package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流写出数据时，缓冲区的问题
 */
public class BOS_flushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String str = "夜空中最亮的星，是你的眼睛";
        byte[] data = str.getBytes("UTF-8");
        bos.write(data);
        /*
            void flush()方法是在java.io.OutputStream中定义的方法，所有字节输出都支持
            这个方法，实际上只有缓冲流真正实现了这个方法，用于将缓冲区中已经缓存的数据一次性写出
            其它流实现的目的只是用于传递该方法。
         */
        bos.flush();
        System.out.println("写出完毕");
        /*
            缓冲流的close方法会自动调用依次flush方法，确保关闭前缓冲区的数据会被写出
         */
        bos.close();
    }
}
