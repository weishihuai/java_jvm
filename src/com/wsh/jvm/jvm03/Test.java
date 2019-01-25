package com.wsh.jvm.jvm03;


import java.util.Scanner;

/**
 * @Description: JDK内置命令
 * @author: weishihuai
 * @Date: 2019/1/25 16:53
 */
public class Test {
    public static void main(String[] args) {
        for (String string : args) {
            System.out.println(string);
        }
        //-Xmx20m -Xms20m
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}
