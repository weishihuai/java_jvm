package com.wsh.jvm.classloader03;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/17 14:42
 */
public class TestClassLoad {

    static {
        System.out.println("init static block");
    }

    public static void main(String[] args) {
        System.out.println("TestClassLoad");
    }
}
