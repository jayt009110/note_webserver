package exception;

/**
 * 异常常见面试题
 *
 * 1.请分别说明final,finally,finalize
 * final是个关键字：修饰类，方法，变量
 * 变量不能被改变，方法无法被重写，类无法被继承
 *
 * finally：通常绑定try-catch，无论是否抛出异常，都会执行，一般用于释放资源的操作
 *
 * finalize:finaize是java.lang.Object里的一个方法，目的是保证对象在被垃圾收集前完成特定资源
 * 的回收，
 * 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
 * 当一个对象即将被GC释放时，GC会调用该方法，一旦方法调用完毕，这个对象即被释放
 * 注意:这个操作中不应当有耗时的操作
 *
 *
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        System.out.println(
                test("0")+","+test(null)+","+test("")
        );
    }
    public static int test(String str){
        try {
            return '0'-str.charAt(0);
        }catch (NullPointerException e){
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
}
