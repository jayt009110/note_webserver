package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射调用有参构造器实例
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person p = new Person("sd",33);
        //获取类对象
        Class cls = Class.forName("reflect.Person");
        //通过类对象获取对应的构造器
        Constructor c = cls.getConstructor(String.class,int.class);
        //通过构造器对象进行实例化
        Object p1 = c.newInstance("daa",55);
        System.out.println(p1);
    }
}
