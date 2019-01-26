package com.wsh.jvm.classloader04;

/**
 * @Description: 类加载过程示例
 * @author: weishihuai
 * @Date: 2019/1/14 15:30
 * <p>
 * 说明: 注意静态变量初始化顺序问题(从上到下依次执行)
 * 下面两个代码的区别主要在于 类加载 --> 准备 阶段部分的区别
 */
public class TestClassLoader {
    public static void main(String[] args) {
        SingleTone instance = SingleTone.getInstance();
        System.out.println("num1-->" + SingleTone.num1);
        System.out.println("num2-->" + SingleTone.num2);
        System.out.println("##############");
        SingleTone2 instance2 = SingleTone2.getInstance();
        System.out.println("num3-->" + SingleTone2.num3);
        System.out.println("num4-->" + SingleTone2.num4);
    }

}

class SingleTone {
    /**
     * 准备阶段: 为类的静态变量赋予默认值,注意不是初始值
     * singleTone=null / num1 = 0 / num2 = 0
     * <p>
     * 初始化阶段: 为类的静态变量赋予正确的初始值,注意从上到下初始化
     * 执行完private static SingleTone singleTone = new SingleTone();语句之后 singleTone = new SingleTone(); / num1 = num1++ = 1 / num2 = num2++ = 1
     * 执行完static int num1;语句之后 singleTone = new SingleTone(); / num1 = 1 / num2 = 1
     * 执行完static int num2 = 0;语句之后 singleTone = new SingleTone(); / num1 = 1 / num2 = 0
     * <p>
     * 全部代码执行完成后: singleTone = new SingleTone(); / num1 = 1 / num2 = 0
     */
    private static SingleTone singleTone = new SingleTone();
    static int num1;
    static int num2 = 0;

    private SingleTone() {
        num1++;
        num2++;
    }

    static SingleTone getInstance() {
        return singleTone;
    }

}

class SingleTone2 {
    /**
     * 准备阶段: 为类的静态变量赋予默认值,注意不是初始值
     * singleTone=null / num1 = 0 / num4 = 0
     * <p>
     * 初始化阶段: 为类的静态变量赋予正确的初始值,注意从上到下初始化
     * 执行完static int num3;语句之后 singleTone = null; / num3 = 0 / num4 = 0
     * 执行完static int num4 = 0;语句之后 singleTone = null; / num3 = 0 / num4 = 0
     * 执行完private static SingleTone singleTone = new SingleTone();语句之后 singleTone = new SingleTone(); / num3 = num3++ = 1 / num4 = num4++ = 1
     * <p>
     * 全部代码执行完成后: singleTone = new SingleTone(); / num3 = num3++ = 1 / num4 = num4++ = 1
     */
    static int num3;
    static int num4 = 0;
    private static SingleTone2 singleTone2 = new SingleTone2();

    private SingleTone2() {
        num3++;
        num4++;
    }

    static SingleTone2 getInstance() {
        return singleTone2;
    }

}

