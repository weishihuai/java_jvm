package com.wsh.jvm.classloader02;

import java.io.*;

/**
 * @Description: 加密工具类
 * @Author: weishihuai
 * @Date: 2019/1/16 21:26
 */
public class EncrptUtil {
    public static void main(String[] args) {
        encryptClass(new File("d:/java/com/wsh/Test.class"), new File("d:/java/temp/com/wsh/Test.class"));
    }

    /**
     * 加密方法
     *
     * @param src  源文件路径
     * @param dest 目标文件路径
     */
    public static void encryptClass(File src, File dest) {
        InputStream fileInputStream = null;
        OutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(dest);

            //接收长度
            int len;
            while ((len = fileInputStream.read()) != -1) {
                //通过异或操作对读取的输入流进行取反
                fileOutputStream.write(len ^ 0xff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != fileInputStream) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
