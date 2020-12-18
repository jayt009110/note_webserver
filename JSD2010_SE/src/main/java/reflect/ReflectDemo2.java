package reflect;

import java.util.Scanner;

/**
 * 使用反射进行实例化
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Person p = new Person();
//        System.out.println(p);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入类名:");
        String clsname = sc.nextLine();
        //获取类对象
        Class cls = Class.forName(clsname);
        //实例化类对象
        Object obj = cls.newInstance();  //只能调用无参构造器的实例
        System.out.println(obj);
    }
}
