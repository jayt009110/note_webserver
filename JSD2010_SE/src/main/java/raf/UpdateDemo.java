package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成修改昵称功能
 * 程序启动后要求用户输入用户名和新的昵称
 * 然后将user.dat文件中该用户的昵称进行修改，如果输入的用户名不存在则提示：查无此人
 *
 * 思路：
 * 先读取User.dat文件每条记录的用户名与输入的用户名进行比对
 * 找到这个用户所在记录后，将指针移动到这条记录的昵称位置，并将新昵称转换为字节数后扩容
 * 至32字节并重新写入覆盖旧昵称完成修改操作
 *
 */
public class UpdateDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String uname = sc.nextLine();
        System.out.println("请输入新的昵称:");
        String nickuname = sc.nextLine();
        boolean isupdate = false;
        RandomAccessFile raf = new RandomAccessFile("inf.dat","rw");
        byte[] data = new byte[32];
        for (int i=0;i<raf.length()/100;i++){
            raf.seek(100*i);
            raf.read(data);
            String name = new String(data,"UTF-8").trim();
            raf.read(data);
            String nickname = new String(data,"UTF-8").trim();
            if(name.equals(uname)){

                raf.seek(64+100*i);
                byte[] update = nickuname.getBytes("UTF-8");
                update = Arrays.copyOf(update,32);
                raf.write(update);
                raf.seek(64+100*i);
                raf.read(data);
                String update_nickname = new String(update,"UTF-8").trim();
                System.out.println(uname+","+update_nickname);
                isupdate = true;
            }
        }
        if(!isupdate){
            System.out.println("查无此人");
        }
        raf.close();

    }
}
