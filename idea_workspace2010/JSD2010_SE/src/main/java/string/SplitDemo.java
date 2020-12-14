package string;

/**
 * String支持正则表达式方法二：
 * String[] split(String regex)
 * 将当前字符串中满足正则表达式的部分进行拆分，将拆分出的各部分内容以一个数组形式返回
 */
public class SplitDemo {
    public static void main(String[] args) {
        String str = "213sdsf12312fdsf";
        String[] arr = str.split("[0-9]+");
        /*
        如果在字符串最开始就遇到拆分项，那么拆分在最开始就会拆分出一个空字符串，
        如果遇到连续两个拆分项，中间会拆分出一个空的字符串，
        但是如果是末尾遇到拆分项，拆分的空字符串会被忽略。
         */
        String str1 = "123,12323,3,323,";
        String[] arr1 = str1.split("\\.");
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
        System.out.println(arr1.length);
    }
}
