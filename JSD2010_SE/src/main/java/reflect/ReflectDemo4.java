package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 利用反射调用方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person p = new Person();
        p.sayHello();


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入类名:");
        String clsname = sc.nextLine();
        System.out.println("请输入方法名");
        String method = sc.nextLine();
        //获取类对象
//        Class cls = Class.forName("reflect.Person");
        Class cls = Class.forName(clsname);
        //实例化类对象
        Object obj = cls.newInstance();
        //获取类对象的方法
//        Method method = cls.getMethod("sayHello");
        Method method1 = cls.getMethod(method);
        //调用类对象的方法
        method1.invoke(obj);

    }
}
