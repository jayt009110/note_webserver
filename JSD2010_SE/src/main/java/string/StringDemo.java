package string;

/**
 * String是不可变的对象。即：String对象创建后内容不可以改变，改变内容一定是创建了新的对象
 * 这是因为Java对字符串的一个优化导致的——字符串常量池
 * java推荐我们使用字面量（直接量）形式创建字符串，并且使用这种方式创建字符串时会缓存该
 * 字符串对象在常量池中（java在堆内存中开辟了一个空间专门缓存这些字符串）,这样我们再次使用
 * 该字面创建字符串时会重用对象来减少内存开销，避免内存中堆积大量内容一样的字符串对象。
 *
 */
public class StringDemo {
    public static void main(String[] args) {
//        String s1 = "123abc";
        String s2 = "123abc";
//        System.out.println(s1 == s2);
//
        /*
        这里有一个编译器小特性：
        编译器编译源代码如果发现一个计算表达式在编译期间可以确定结果时就会进行计算
        并将结果编译到class文件中，如下的代码会被编译器编译为：
        String s4 = "123abc"
         */
        String s4 = "123" + "abc";
        System.out.println(s2 == s4);
        String s = "123";
        String s5 = s + "abc";
        System.out.println(s2 == s5);
        /*
            对于引用类型而言，由于变量本身存的值是对象在堆里的地址。因此
            ==在比较时含义为比较两个地址是否相同，而不关心是否为同一个对象
            对于字符串而言，通常我们使用equals进行比较
         */
        System.out.println(s2.equals(s5));
//        s1 = s1 + "!";
//        System.out.println("s1:"+s1);
//        System.out.println("s2:"+s2);
//        System.out.println(s1 == s2);
    }
}
