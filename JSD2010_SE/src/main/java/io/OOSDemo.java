package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流：java.io.ObjectInputStream和ObjectOutputStream
 * 对象流也是一对高级流，使用它们可以方便的读写java中任何类型的实例，因为他们会将对象与字节
 * 之间进行转换
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        /*
            将一个Person实例写入文件person.obj中
         */
        String name = "苍老师";
        int age = 18;
        String gender = "女";
        String[] otherinfo = {"动作片女演员","台词不多","启蒙老师","现居北京","促进中日文化交流"};
        Person person = new Person(name,age,gender,otherinfo);
        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        /*
            对象输出流的写出对象方法：writeObject要求写出对象所属的类必须实现可序列化接口
            否则会抛出异常:java.io.NotSerializableException

            序列化:将一个对象按照其结构转换为一组字节的过程
            持久化：将数据写入磁盘长久保存的过程
         */
        oos.writeObject(person);

        System.out.println("写入完毕");
        oos.close();
    }
}
