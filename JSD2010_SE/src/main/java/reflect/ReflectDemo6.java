package reflect;

import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();
        Method private_method = cls.getDeclaredMethod("hehe");
        private_method.setAccessible(true); //强制访问
        private_method.invoke(o);
    }



}
