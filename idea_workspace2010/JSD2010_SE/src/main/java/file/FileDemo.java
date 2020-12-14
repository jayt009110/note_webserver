package file;

import java.io.File;
/**
 * java.io.file
 * File的每一个实例可以表示硬盘上的一个文件或者目录
 * 使用File可以：
 * 1.访问文件或目录的属性信息（名字，大小等）
 * 2.创建，删除文件或目录
 * 3.访问一个目录中的所有子项
 *
 * 但是不能访问文件数据
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("./demo.txt");
        System.out.println(file.length());
        boolean ishide = file.isHidden();
        System.out.println("是否隐藏："+ishide);
        boolean cr = file.canRead();
        System.out.println("可读:"+cr);
        boolean cw = file.canWrite();
        System.out.println("可写:"+cw );
    }
}
