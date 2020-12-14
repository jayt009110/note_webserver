package file;

import java.io.File;

/**
 * 获取一个目录的所有子项
 */
public class ListFileDemo {
    public static void main(String[] args) {
        //获取当前目录下的所有子项
        File file = new File("./src");
        /*
        File[] listFiles()
        获取当前File表示的目录中的所有子项，每个子项都是一个File对象
        最终以一个数组形式返回
         */
        if(file.isDirectory()){
            File[] subs = file.listFiles();
            for (int i=0;i<subs.length;i++){
                System.out.println(subs[i]);
            }
        }
    }
}
