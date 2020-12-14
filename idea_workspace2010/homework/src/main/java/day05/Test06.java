package day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 读取content.txt文件
 * 该文件有很多句话构成，每一句结尾是符号"."
 * 
 * 实现方法read(),只读取content.txt文件中第一句的每个字符
 * 
 * 提示:
 * 实现循环读取每一个字符,并输出。
 * 当读取到"."的时候停止循环。
 * 
 * 
 * @author Xiloer
 *
 */
public class Test06 {
	public static void main(String[] args) throws IOException {
		read();
	}
	
	public static void read() throws IOException {
		FileInputStream fis = new FileInputStream("content.txt");
		String point = ".";
		String ch = "";
		int len;
		while((len=fis.read())!=-1){

			if(ch.endsWith(point)){
				StringBuilder sb = new StringBuilder(ch);
				System.out.println(sb.delete(ch.length()-1,ch.length()));
				break;
			}
			else{
				ch +=(char)len;

			}


		}
		fis.close();
	}
}
