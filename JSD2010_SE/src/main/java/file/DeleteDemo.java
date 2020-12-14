package file;

import java.io.File;

/**
 * 删除一个文件
 */
public class DeleteDemo {
    public static void main(String[] args) {
        //将当前目录下的test.txt删掉
        for(int i=1;i<101;i++){
            File file = new File("./test"+i+".txt");
            if(file.exists()){
                file.delete();
            }
            else {
                System.out.println("文件不存在");
                break;
            }
        }



    }
}
