package file;

import java.io.File;

/**
 * 删除一个目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        //删除当前目录下的demo目录
        File file = new File("demo.txt");
        if(file.exists()){
            file.delete();
            System.out.println("目录已删除");
        }
        else {
            System.out.println("目录不存在");
        }
    }
}
