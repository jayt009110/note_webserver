package socket;

import java.net.Socket;
import java.util.Arrays;

/**
 * 从数组中删除元素
 */

public class Test {
    public static void main(String[] args) {
        int[] num = {123,32,13,31,23,1,231,234,4};
        int pw = 32;
        System.out.println(Arrays.toString(num));
        //将pw从allOut中删除
        for(int i=0;i<num.length;i++){
            if(num[i]==pw){
                num[i] = num[num.length-1];
                num = Arrays.copyOf(num,num.length-1);
                break;
            }
        }
        System.out.println(Arrays.toString(num));

    }
}
