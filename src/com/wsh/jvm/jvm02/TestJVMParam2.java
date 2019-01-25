package com.wsh.jvm.jvm02;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/25 16:20
 */
public class TestJVMParam2 {
    public static void main(String[] args) {
        //第一次配置：-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        //第二次配置：-Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        //第三次配置：-Xms20m -Xmx20m -XX:NewRadio=2 -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        byte[] buffer = null;
        //连续向系统申请10M内存空间
        for (int i = 0; i < 10; i++) {
            buffer = new byte[1024 * 1024];
        }

    }
}
