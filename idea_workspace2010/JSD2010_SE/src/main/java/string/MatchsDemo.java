package string;

/**
 * String支持正则表达式的方法一：
 * boolean matches(String regex)
 * 使用正则表达式验证当前字符串的格式，匹配则返回true
 * 注：给定的正则表达式不写边界匹配也是做边界匹配的
 */
public class MatchsDemo {
    public static void main(String[] args) {
        String mail = "leifluo@163.cn";
        /*
        [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
         */
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        boolean match = mail.matches(regex);
        if (match){
            System.out.println("是邮箱");
        }
        else{
            System.out.println("不是邮箱");
        }
    }
}
