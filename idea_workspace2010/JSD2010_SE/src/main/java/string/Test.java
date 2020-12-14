package string;

public class Test {
    public static void main(String[] args) {
        String name1 = getHostName("www.tedu.com");
        String name2 = getHostName("http://doc.canglaoshi.org");
        String name3 = getHostName("tts.tedu.com.cn");
        String name4 = getHostName("www.baidu.com");
        System.out.println(name4);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    }
    public static  String getHostName(String line){
        int start = line.indexOf(".");
        int end = line.indexOf(".",start+1);
        String str = line.substring(start+1,end);
        return str;

    }
}
