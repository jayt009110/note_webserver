package day05;

import java.io.*;

/**
 * 将当前目录下的所有obj文件获取到，并进行
 * 反序列化后输出每个用户的信息(直接输出反序
 * 列化后的User对象即可)
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File filename = new File(".");
        File[] file = filename.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                boolean name = file.getName().endsWith(".obj")&&file.isFile();
                return name;
            }
        });
        for(int i=0;i<file.length;i++){
            FileInputStream fis = new FileInputStream(file[i]);
            ObjectInputStream ois = new ObjectInputStream(fis);

            User u = (User)ois.readObject();
            System.out.println(u);
        }
    }
}
