package file;

import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //当前目录下创建100个文件，分别为test1-test100
        for(int i=1;i<=100;i++){
            File file = new File("./test"+i+".txt");
            file.createNewFile();

        }

    }
}
