package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象字节输入流
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
            读取person.obj文件，将里面的数据还原为Person对象
         */
        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
            readObject方法可能抛出异常:ClassNotFoundException
            这是因为该方法要求读取的字节必须是通过对象输出流将一个对象转换的一组字节
            否则无法进行还原
         */
        Person p =  (Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
