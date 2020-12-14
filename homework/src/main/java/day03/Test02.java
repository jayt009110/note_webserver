package day03;

import java.io.File;
import java.io.FileFilter;
/**
 * 列出当前目录中所有名字包含s的子项。
 *
 * 使用匿名内部类和lambda两种写法
 *
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 *
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) {
        File file = new File(".");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                boolean ends = name.contains("s");
                return ends;
            }
        };
        FileFilter filter1 =(file1)->file1.getName().contains("s");

    }
}
