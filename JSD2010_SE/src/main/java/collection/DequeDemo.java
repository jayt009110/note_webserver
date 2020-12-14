package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java.util.Deque,双端队列
 * Deque继承自Queue,是队列两端都可以进入队的队列
 *
 * 常用实现类:java.util.LinkedList
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.offer("one");
        deque.offer("two");
        deque.offer("three");
        deque.offer("four");
        deque.offer("five");
        System.out.println(deque);

        //从队首入栈
        deque.offerFirst("six");
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);

        deque.pollLast();
        System.out.println(deque);
    }
}
