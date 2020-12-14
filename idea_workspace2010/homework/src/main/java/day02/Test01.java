package day02;

import java.util.Scanner;

/**
 * 正则表达式练习:
 * 1:编写匹配数字的正则表达式,数字至少一位以上.
 *
 * 2:匹配字符串,要求输入3-15位,内容只能是数字,字母下,划线
 *
 *
 * 完成下面编程题:
 * 程序启动后,要求用户输入用户名,用户名出现内容要求上述正则表达式2的要求.不匹配则直接
 * 提示用户名有误.
 * 如果无误,则要求用户继续输入年龄,规则为上述正则表达式1的要求,不匹配则提示年龄有误
 * 以上两个输入获取是都要求以字符串形式接受(Scanner的nextLine方法获取)
 *
 * 最后验证年龄在1-100岁之间(包含1和100)
 * 提示:这里可以不用正则表达式验证范围,是否转换为数字判定更方便?
 * @author Xiloer
 *
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String uname = sc.nextLine();
        String match_num = "[0-9]+";
        String match_dig = "[a-zA-Z0-9_]{3,15}";
        boolean match_uname = uname.matches(match_dig);
        if(match_uname){
            System.out.println("请输入年龄：");
            String age = sc.nextLine();
            boolean match_age = age.matches(match_num);
            if(match_age){
                int age1 = Integer.parseInt(age);
                if(0<age1&&age1<101){
                    System.out.println("年龄合格");
                }
            }
            else{
                System.out.println("年龄不匹配");
            }
        }
        else {
            System.out.println("用户名有误");
        }
    }
}