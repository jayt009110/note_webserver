package file;

import java.io.File;

/**
 * 创建一个目录
 */
public class MkdirDemo {
    public static void main(String[] args) {
        //在当前目录下新建一个目录叫demo
        File file = new File("demo");
        if(file.exists()){
            System.out.println("目录已存在");
        }
        else {
            file.mkdir();
        }
    }

}
