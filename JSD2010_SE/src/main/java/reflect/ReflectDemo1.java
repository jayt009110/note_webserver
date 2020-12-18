package reflect;

import java.lang.reflect.Method;

/**
 * java反射机制
 * 反射是一个动态机制,允许我们在程序运行期间确定对象的实例化，方法和
 * 属性操作
 * 反射可以提高代码的灵活度，但是也带来了跟多的系统开销和较慢的运行效率
 * 因此不应当过度使用
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            Class类，称为类的类对象
            JVM内部每个被加载的类都有且只有一个Class实例与之对应，通过
            类对象可以获取到其表示的类而定一切信息(类名，有哪些方法，属性
            构造器等).并对该类进行相关操作,因此反射的第一步就是获取操作类的
            类对象.
            获取第一个类的类对象有三种方式：
            获取一个类的类对象有三种方式:
            1:类名.class
            例如:
            Class cls = String.class;
            Class cls = int.class://基本类型只有这种获取方式

            2:Class.forName(String className)
            通过Class的静态方法forName可以获取一个类的类对象，参数为该类的完全
            限定名.
            即:包名,类名
            例如:
            Class cls = Class.forName("java.lang.String");

            3:使用类加载器ClassLoader
         */

        //获取String类对象来了解String的相关信息
//        Class cls = String.class;
        /*
            java.lang.String
            java.util.ArrayList
            java.util.HashMap
            java.io.FileOutputStream
            java.lang.Thread
         */
        Class cls = Class.forName("java.lang.Thread`");
        String d = cls.getName();
        System.out.println(d);
        String f = cls.getSimpleName();
        System.out.println(f);

        Method[] method = cls.getMethods();
        for(Method method1:method){
            String name = method1.getName();
            System.out.println(name);
        }
    }
}
