package com.wsh.jvm.classloader02;

/**
 * @Description: 测试解密类加载器
 * @Author: weishihuai
 * @Date: 2019/1/16 21:40
 */
public class TestDecrptClassLoader {
    public static void main(String[] args) {
//        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("d:/java/temp");
//        try {
//            Class<?> clazz = fileSystemClassLoader.loadClass("com.wsh.Test");
//            System.out.println(clazz);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        DecipherClassLoader decipherClassLoader = new DecipherClassLoader("d:/java/temp");
        try {
            Class<?> clazz2 = decipherClassLoader.loadClass("com.wsh.Test");
            System.out.println(clazz2);
            System.out.println(clazz2.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
