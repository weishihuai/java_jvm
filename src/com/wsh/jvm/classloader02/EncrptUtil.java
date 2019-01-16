package com.wsh.jvm.classloader02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: 加密工具类
 * @Author: weishihuai
 * @Date: 2019/1/16 21:26
 */
public class EncrptUtil {
    public static void main(String[] args) {
        encrpt(new File("d:/java/com/wsh/Test.class"), new File("d:/java/temp/com/wsh/Test.class"));
    }

    public static void encrpt(File src, File dest) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(dest);

            int len;
            while ((len = fileInputStream.read()) != -1) {
                //取反
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
