package collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue 队列
 * Queue接口继承自Collection,所以也是集合的一种子类分支.
 * Queue可以保存一组元素，但是存取元素必须遵循先进先出的原则.
 * 常用实现类:java.util.LinkedList
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        //入队操作
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        queue.offer("five");
        System.out.println(queue);

        //出队操作
        String str = queue.poll();
        System.out.println(str);
        System.out.println(queue);
        /*
            使用新循环（迭代器）遍历队列元素，元素仍然还在队列中
         */
        str = queue.peek();
        System.out.println(str);
        System.out.println(queue.size());

        //使用poll方法遍历队列（一次性的）
        while(queue.size()!=0){
            str = queue.poll();
            System.out.println(str);
        }
    }
}
