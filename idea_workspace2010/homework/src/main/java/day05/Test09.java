package day05;
/**
 * 先将content2.txt文件拷贝到项目目录中
 * 
 * 进阶，实现readLine方法，每调用一次读取content2.txt
 * 文件中的一句话。这个文件中每句话都是以",."结束的。
 * 
 * 提示:
 * 由于读取的循环中，每次只读取一个字符，所以如何才能判断
 * 连续读取了","和"."？
 * 应当在每次读取字符后，在下次读取前将这个字符记下来，
 * 然后再下次循环中读取一个字符后，就可以通过记下来的字符
 * 和本次读取的字符判定了。
 * 
 * @author Xiloer
 *
 */
public class Test09 {
	public static void main(String[] args) {
		String line = readLine();
		//hello world
		System.out.println(line);
		
		line = readLine();
		//thinking in java
		System.out.println(line);
		
		line = readLine();
		//i love java
		System.out.println(line);
	}
	
	public static String readLine() {
		return "";
	}
}
