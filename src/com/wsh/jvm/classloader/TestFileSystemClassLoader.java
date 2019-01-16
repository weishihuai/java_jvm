package com.wsh.jvm.classloader;

/**
 * @Description: 测试自定义类加载器
 * @author: weishihuai
 * @Date: 2019/1/16 16:51
 */
public class TestFileSystemClassLoader {
    public static void main(String[] args) {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("d:/java");
        try {
            //加载d:/java/com/wsh/Test.class字节码信息
            Class<?> loaderClass = fileSystemClassLoader.findClass("com.wsh.Test");
            //class com.wsh.Test
            System.out.println(loaderClass);
            //com.wsh.jvm.classloader.FileSystemClassLoader@677327b6
            System.out.println(loaderClass.getClassLoader());

            Object object = loaderClass.newInstance();
            //com.wsh.jvm.classloader.FileSystemClassLoader@677327b6
            System.out.println(object.getClass().getClassLoader());

            Class<?> loaderClass2 = fileSystemClassLoader.findClass("com.wsh.jvm.classloader.Test");
            //由于双亲委托机制,在classpath下的类默认都会由AppClassLoader类加载器加载
            //sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println(loaderClass2.getClassLoader());

            Class<?> loaderClass3 = fileSystemClassLoader.findClass("java.lang.String");
            //因为Java核心类库是由引导类加载器BootStrapClassLoader进行加载,所以返回为null
            //null
            System.out.println(loaderClass3.getClassLoader());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
