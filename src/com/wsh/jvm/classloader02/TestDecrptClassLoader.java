package com.wsh.jvm.classloader02;

import com.wsh.jvm.classloader.FileSystemClassLoader;

/**
 * @Description:
 * @Author: weishihuai
 * @Date: 2019/1/16 21:40
 */
public class TestDecrptClassLoader {
    public static void main(String[] args) {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("d:/java/temp");

        DecrptClassLoader decrptClassLoader = new DecrptClassLoader("d:/java/temp");

        try {
            Class<?> clazz = fileSystemClassLoader.loadClass("com.wsh.Test");
            System.out.println(clazz);

            Class<?> c2 = decrptClassLoader.loadClass("com.wsh.Test");
            System.out.println(c2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
