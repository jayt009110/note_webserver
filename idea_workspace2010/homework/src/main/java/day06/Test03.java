package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 编写一个记事本工具
 *
 * 程序启动后，要求用户输入一个文件名。如果该文件不存在
 * 则直接创建。
 * 如果存在，则提示用户:
 * "该文件已存在，是否更换文件名?[y]更换，[n]不更换"
 * 让用户输入y或n决定
 * 如果更换则重新只要求用户输入文件名。
 *
 * 如果不更换，则提示用户:
 * 是重新编写文件内容，还是继续写入文件内容?[y]重新 [n]继续
 * 如果是重新写，则将该文件原来的数据全部抹除
 * 如果是继续写，则将写入的内容都追加到文件中。
 *
 * 之后用户输入的每一行字符串都要写入到文件中，当用户单独
 * 输入"exit"是程序退出。
 *
 *
 *
 * @author Xiloer
 *
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String filename = sc.nextLine();
        out:while (true){
            File file = new File(filename);
            if (file.exists()){
                System.out.println("是否更换文件？[y]更换，[n]不更换");
                String ischange = sc.nextLine();
                if ("y".equalsIgnoreCase(ischange)) {
                    System.out.println("请输入文件名:");
                    filename = sc.nextLine();
                }
                else if("n".equalsIgnoreCase(ischange)){
                    System.out.println("是重新编写内容还是继续写入文件内容?[y]重新，[n]继续");
                    String iscontinue = sc.nextLine();
                    if("y".equalsIgnoreCase(iscontinue)){
                        try (
                                FileOutputStream fos = new FileOutputStream(filename);
                        ){
                            System.out.println("请输入内容:");
                            while (true){
                                String content = sc.nextLine();
                                if("exit".equalsIgnoreCase(content)){
                                    break out;
                                }
                                fos.write(content.getBytes("UTF-8"));

                            }

                        } catch (Exception e) {
                            System.out.println("出错了");
                        }

                    }
                    else if("n".equalsIgnoreCase(iscontinue)){
                        try(FileOutputStream fos = new FileOutputStream(filename,true);
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        BufferedWriter bw = new BufferedWriter(osw);
                        PrintWriter pw = new PrintWriter(bw);
                        ) {
                            System.out.println("请输入内容:");
                            while (true) {
                                String content = sc.nextLine();
                                if ("exit".equalsIgnoreCase(content)) {
                                    System.out.println("退出");
                                    break out;
                                }
                                pw.print(content);
                            }
                        }catch (Exception e){
                            System.out.println("出错了");
                        }
                    }

                }
                }
                else{
                try(FileOutputStream fos = new FileOutputStream(filename,true);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    BufferedWriter bw = new BufferedWriter(osw);
                    PrintWriter pw = new PrintWriter(bw);
                ) {
                    System.out.println("请输入内容:");
                    while (true) {
                        String content = sc.nextLine();
                        if ("exit".equalsIgnoreCase(content)) {
                            System.out.println("退出");
                            break out;
                        }
                        pw.print(content);
                    }
                }catch (Exception e){
                    System.out.println("出错了");
            }

            }


        }
        }
    }

