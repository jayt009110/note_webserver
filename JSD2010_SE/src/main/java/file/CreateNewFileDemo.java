package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File新建一个文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前目录下创建一个名为test.txt的文件
        File file = new File("./test.txt");
        /*
        boolean exists()
        判断当前FIle表示的文件或目录是否已经存在
         */
        if(file.exists()){
            System.out.println("文件已存在");
        }
        else {
            file.createNewFile();
            System.out.println("该文件已创建");
        }
    }
}
