package string;

public class StringBuilderDemo2 {
    public static void main(String[] args) {
        String str = "a";
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<1000000;i++){
            str += "a";
        }
        System.out.println("执行完毕");
    }
}
