package com.wsh.jvm.classloader02;

import java.io.*;

/**
 * @Description: 解密类加载器
 * @Author: weishihuai
 * @Date: 2019/1/16 21:36
 */
public class DecrptClassLoader extends ClassLoader {
    /**
     * 根目录路径
     */
    private String rootDir;

    public DecrptClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //1. 查找该类加载器是否已经装载这个类,如果已经装载,则直接返回该Class对象
        Class<?> loadedClass = findLoadedClass(name);
        if (null == loadedClass) {
            //如果未装载,依据双亲委托机制,寻找父类加载器进行加载
            ClassLoader parent = this.getParent();
            try {
                loadedClass = parent.loadClass(name);
            } catch (Exception e) {
//                e.printStackTrace();
            }

            //如果父类加载器加载成功,则返回父类加载器加载的Class对象
            if (null != loadedClass) {
                return loadedClass;
            } else {
                //文件流读取返回字节数组
                byte[] classData = getClassData(name);
                //如果自己都加载失败的话直接抛出ClassNotFoundException异常
                if (null == classData) {
                    throw new ClassNotFoundException();
                } else {
                    //使用defineClass()加载类
                    loadedClass = defineClass(name, classData, 0, classData.length);
                }
            }
        } else {
            return loadedClass;
        }
        return loadedClass;
    }

    /**
     * 根据路径名称获取.class字节数组信息
     *
     * @param name 路径
     * @return
     */
    private byte[] getClassData(String name) {  //com.wsh.Test  d:/java/com/wsh/Test.class
        StringBuilder path = new StringBuilder(rootDir).append(File.separator).append(name.replace(".", File.separator)).append(".class");
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path.toString());

            int len;
            while ((len = inputStream.read()) != -1) {
                //取反
                byteArrayOutputStream.write(len ^ 0xff);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != byteArrayOutputStream) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
