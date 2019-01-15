package com.wsh.jvm.jvm01;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/15 17:02
 */
public class JVM01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(Cat.value);

    }
}

class Cat {
    static int value = 100;

    static {
        System.out.println("静态初始化类Cat...");
        value = 200;
    }

    public Cat() {
        System.out.println("创建Cat类对象...");
    }
}