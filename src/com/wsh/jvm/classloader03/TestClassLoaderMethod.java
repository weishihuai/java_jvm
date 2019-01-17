package com.wsh.jvm.classloader03;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/17 14:49
 */
public class TestClassLoaderMethod {
    public static void main(String[] args) {
        try {
//            Class<?> clazz = Class.forName("com.wsh.jvm.classloader03.TestClassLoad");
            //使用Class.forName()方法会执行静态代码块进行初始化
            //init static block

            //如果指定initialize = false的话则不会进行执行静态代码块初始化
            Class.forName("com.wsh.jvm.classloader03.TestClassLoad", false, ClassLoader.getSystemClassLoader());

            ClassLoader classLoader = TestClassLoaderMethod.class.getClassLoader();
//            使用ClassLoader.loadClass()方法默认不会执行静态代码块进行初始化
            Class<?> clazz2 = classLoader.loadClass("com.wsh.jvm.classloader03.TestClassLoad");
            //执行了newInstance()方法之后会执行静态代码块
            //init static block
            clazz2.newInstance();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
