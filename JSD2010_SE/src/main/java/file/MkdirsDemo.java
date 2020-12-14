package file;

import java.io.File;

/**
 * 创建多级目录
 */
public class MkdirsDemo {
    public static void main(String[] args) {
        File file = new File("./demo/a/b/c/d");
        if(file.exists()){
            System.out.println("目录已存在");
        }
        else {
            file.mkdirs();
            System.out.println("目录已创建");

        }
    }

}
