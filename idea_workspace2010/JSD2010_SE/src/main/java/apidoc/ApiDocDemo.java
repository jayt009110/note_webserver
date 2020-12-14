package apidoc;

/**
 * 文档注释是功能级注释，只在三个地方使用：类上，方法上，常量上
 *
 * 在类上使用用于说明当前类的的设计意图和功能介绍
 * @author llf
 */
public class ApiDocDemo {
    /**
     * sayHello使用问候语
     *
     */
    public  static final String INFO = "你好";
    /**
     * 对指定用户添加问候语
     * @param name 给定的用户名
     * @return 含有问候语的字符串
     */
    public String sayHello(String name){
        return INFO+name;



    }
}


