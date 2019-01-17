package com.wsh.jvm.classloader03;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/17 11:23
 */
public class Test {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("contextClassLoader = " + contextClassLoader);

        //线程上下文类加载器
//        Thread.currentThread().setContextClassLoader();
    }
}
