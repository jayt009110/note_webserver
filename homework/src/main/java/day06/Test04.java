package day06;

import java.io.*;

/**
 * 扫描指定目录中的所有.java文件，并将内容全部输出到控制台
 *
 * 例如将当前项目目录下src/io目录中的所有java文件内容输出
 * 到控制台
 *
 * 1:先要定位./src/io目录(哪个API用来描述目录?)
 * 2:获取该目录下的所有.java文件
 * 3:遍历每一个java文件，然后按行读取里面的每一行字符串
 *   并输出控制台
 *
 *   注意，流用完了要关闭，可以用autocloseable特性
 *
 *
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) {
        File file = new File("./src/main//java/day01");
        if(file.isDirectory()){
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".java")&&file.isFile();
                }
            });
            for(int i=0;i<files.length;i++){
                try(FileInputStream fis = new FileInputStream(files[i]);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                ){
                    String d;
                    while((d=br.readLine())!=null){
                        System.out.println(d);
                    }
                }catch (Exception e){
                    System.out.println("出错了");
                }

            }
        }



    }
}
