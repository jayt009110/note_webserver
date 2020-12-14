package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，推出了一个新的特性：自动关闭
 * 可以用更精简的代码完成繁琐的异常处理机制中IO的关闭操作
 */
public class AutoclosableDemo {
    public static void main(String[] args) {
        /*
            只有实施了Autocloseable接口的类才可以在try后面的（）中定义并初始化
            java IO中的流，RadomAccessFile都实现了这个接口

            注意：该语法是java编译器认可的，并且编译后编译器会将代码自动补全
         */
        try(
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ){
            fos.write(1);
        }catch (IOException e){
            System.out.println("出错了");
        }
    }
}
