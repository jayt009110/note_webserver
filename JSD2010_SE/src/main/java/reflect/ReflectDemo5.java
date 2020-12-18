package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用有参方法
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person p = new Person();
        p.say("hello");

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
//        Method method = cls.getMethod("say", String.class);
        Method method = cls.getMethod("say", String.class,int.class);
//        method.invoke(obj,"dasdad");
        method.invoke(obj,"dsafsdf",4);
    }
}
