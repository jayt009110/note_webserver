package lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * lambda表达式
 * JDK8之后，java支持使用lambda表达式
 * 语法：
 * （参数列表）->{
 *     方法体
 * }
 * 可以使用lambda表达式创建匿名内部类，但是实现的接口只能有一个抽象方法时才可以使用
 */
public class LambdaDemo {
    public static void main(String[] args) {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {

                return file.getName().endsWith(".xml");
            }
        };
        FileFilter filter1 =(file)->{
            return  file.getName().endsWith(".xml");
        };
        FileFilter filter2 =(file)->file.getName().endsWith(".xml");
    }
}
