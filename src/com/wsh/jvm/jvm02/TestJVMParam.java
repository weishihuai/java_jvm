package com.wsh.jvm.jvm02;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/25 16:18
 */
public class TestJVMParam {
    public static void main(String[] args) {
        printMemoryInfo();
        System.out.println("#################################");
        byte[] buffer = new byte[1024 * 1024];
        printMemoryInfo();
        System.out.println("#################################");
        byte[] buffer2 = new byte[4 * 1024 * 1024];
        printMemoryInfo();

    }

    private static void printMemoryInfo() {
        System.out.println("最大内存maxMemory-->" + Runtime.getRuntime().maxMemory());
        System.out.println("空闲内存freeMemory-->" + Runtime.getRuntime().freeMemory());
        System.out.println("总内存totalMemory-->" + Runtime.getRuntime().totalMemory());
    }

}
