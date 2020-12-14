package exception;

/**
 * 异常处理机制中的try-catch
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        try {
//            String str = null;
//            String str = "";
            String str = "a";
            System.out.println(str.charAt(0));
            System.out.println(Integer.parseInt(str));
            System.out.println("3242423");
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("字符串下标越界");
            //在最后一个catch出捕获Exception可以避免因为未处理的异常导致程序中断
        }catch (Exception e){
            System.out.println("反正就是出了个错");
        }


        System.out.println("程序结束了");
    }
}
