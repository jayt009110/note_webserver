package Integer;

/**
 * JDK1.5推出时推出了一个新的特性：自动拆装箱
 * 该特性是编译器认可的而非虚拟机，使得我们在编写源代码的时候可以直接在基本类型和对应的包装类
 * 之间相互赋值，无需转换工作。但是编译器编译时会补充转换代码
 */
public class Demo3 {
    public static void main(String[] args) {
        /*
        触发了自动拆装箱特性，编译器会补充代码为：
        int i = new Integer(123).intValue();
         */
        int i = new Integer(123);
        /*
        触发了自动拆装箱特性，编译器会补充代码为：
        Integer in = Integer.valueOf(i);
         */
        Integer in = i;
    }
}
