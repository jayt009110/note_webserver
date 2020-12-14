package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类测试对象流的对象读写操作
 *
 * 如果一个类希望被对象流进行读写，就必须实现接口:java.io.Serializable
 * Serializable接口是一个签名接口,该接口中每月任何抽象方法，这个接口时编译器的敏感接口,
 * 当编译器编译一个类时，如果发现这个类实现了Serializable接口，那么会在编译后的字节码文件中
 * 隐含的添加一个方法，作用是按照当前类结构将这个实例转换为一个字节，对象输出流就是利用这个方法
 * 将当前类实例转换为一组字节后写出的
 *
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private String gender;
    /*
        transient关键字
        被该关键字修饰的属性在进行对象的序列化时会被忽略，忽略不必要的属性可以做到对象瘦身
        减少资源开销
     */
    private  String[] otherinfo;

    public Person(String name, int age, String gender, String[] otherinfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherinfo = otherinfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherinfo=" + Arrays.toString(otherinfo) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String[] otherinfo) {
        this.otherinfo = otherinfo;
    }
}
