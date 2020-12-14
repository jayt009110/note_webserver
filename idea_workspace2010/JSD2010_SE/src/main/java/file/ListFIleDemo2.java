package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 有条件的获取一个目录中的子项
 * 重载的方法：
 * File[] listFiles(FileFilter filter)
 * 获取当前File表示的目录中满足给定过滤器要求的所有子项
 */
public class ListFIleDemo2 {
    public static void main(String[] args) {
        File file = new File(".");
        if(file.isDirectory()){
//            FileFilter filter = new FileFilter() {
//                /*
//                    实现文件过滤器接口必须重写accept方法，该方法定义规律规则
//                    给定的File符合要求时，方法应当返回true
//                 */
//                @Override
//                public boolean accept(File file) {
//                    String name = file.getName();
//                    boolean ends = name.endsWith(".iml");
//                    return ends;
//                }
//            };
//            File[] subs = file.listFiles(filter);
            File[] subs = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    boolean ends = name.endsWith(".iml");
                    return ends;
                }
            });
            System.out.println(subs.length);
            for (int i=0;i<subs.length;i++){
                System.out.println(subs[i].getName());
            }
        }
    }
}
