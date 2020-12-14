package day02;
/**
 * 拆分字符串练习
 *
 * 背景介绍:
 * 上网的时候,浏览器地址栏上有没有留意类似如下的地址形式?
 * https://search.jd.com/Search?keyword=usb&enc=utf-8&wq=usb&pvid=2fb014e3597c4712828926e2f35fa2b5
 *
 * 上面这样的地址称为:URL(什么是URL可以百度一下~)
 *
 * SE后期我们要写一个服务端,就要处理浏览器这样的请求.今天学习的字符串拆分方法在这里意义重大!
 *
 *
 * 单词记一记:
 * path   路径
 * age    年龄
 * local  本地的
 * host   计算机中译为:主机，服务机
 * nickname 昵称
 *
 * reg 是单词register的前三个字母，是注册的意思。
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) {
        String path = "http://localhost:8088/myweb/reg?name=zhangsan";
        /*
         * 将上述字符串按照"?"拆分为两部分并输出
         * ?左侧在控制台输出内容为:
         * 请求:http://localhost:8088/myweb/reg
         *
         * ?右侧在控制台输出内容为:
         * 参数:name=zhangsan
         *
         */
        int index = path.indexOf("?");
        String left = path.substring(0,index);
        String right = path.substring(index+1);
        System.out.println(left);
        System.out.println(right);
    }
}