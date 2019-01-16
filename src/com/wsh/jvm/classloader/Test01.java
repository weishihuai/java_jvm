package com.wsh.jvm.classloader;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/16 14:47
 */
public class Test01 {
    public static void main(String[] args) {
        //获取系统默认的类加载器(应用类加载器)
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(systemClassLoader);

        //应用类加载器的父类是扩展类加载器
        //sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(systemClassLoader.getParent());

        //扩展类加载器的父类是引导类加载器,因为引导类加载器是用C++实现,在Java代码中获取不到该对象,所以返回null
        //null
        System.out.println(systemClassLoader.getParent().getParent());


//        String value = "value";
//        System.out.println(value);
//        System.out.println(String.class.getClassLoader());



    }
}
