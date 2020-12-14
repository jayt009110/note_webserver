package collection;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 栈结构
 * 使用双端队列Deque,如果只从同一侧做出入队操作就形成了栈结构
 *
 * 栈存取元素遵循先进后出的原则，并且双端队列提供了栈经典的出入栈方法：push,pop
 *
 * 通常实际开发中使用栈是为了实现"后退"这样的功能
 */

public class StackDemo {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        System.out.println(stack);

        String pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);

        Iterator<String> it = stack.iterator();
        for(String str:stack){
            System.out.println(str);
        }
        while (stack.size()!=0){
            stack.pop();
        }
        System.out.println(stack);
    }
}
