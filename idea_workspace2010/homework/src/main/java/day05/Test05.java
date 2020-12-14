package day05;

import java.io.*;

/**
 * 先将content.txt文件拷贝到项目目录中
 * 
 * 实现read()方法,读取content.txt文件中的每一个字符并
 * 输出到控制台
 * 
 * 注:该文件中的内容都是英文数字和符号，他们有一个共同的特
 * 点就是都是单字节字符，即:每次从文件中读取一个字节，就可
 * 以将其转换为char,而转换的char就是对应的字符。
 * 
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) throws IOException {
		read();
	}
	
	public static void read() throws IOException {
		FileInputStream fis = new FileInputStream("content.txt");
		int len;
		while((len=fis.read())!=-1){
			System.out.println((char)len);
		}


	}
	
}





