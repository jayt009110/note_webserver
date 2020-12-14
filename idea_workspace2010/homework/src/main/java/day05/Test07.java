package day05;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取content.txt文件
 * 该文件有很多句话构成，每一句结尾是符号"."
 * 
 * 实现方法read(),只读取content.txt文件中第一句的每个字符
 * 并以一个字符串形式返回。返回的字符串中不要这句话中最后的"."
 * 
 * 提示:
 * 实现循环读取每一个字符,并用一个StringBuilder拼接在一起。
 * 当读取到"."的时候停止循环并将StringBuilder拼接后的字符
 * 串返回即可。
 * @author Xiloer
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {
		String s = read();
		System.out.println(s);
	}

	public static String read() throws IOException {
		FileInputStream fis = new FileInputStream("content.txt");

		String point = ".";
		String ch = "";

		int len;
		while ((len = fis.read()) != -1) {

			if (ch.endsWith(point)) {
				StringBuilder sb = new StringBuilder(ch);
				sb.delete(ch.length() - 1, ch.length());
				String sb1 = sb.toString();
				return sb1;
			} else {
				ch += (char)len;

			}


		}
		fis.close();
		return  "";
	}
}
