package com.wsh.jvm.nestedclass;

/**
 * @Description: 静态内部类
 * @Author: weishihuai
 * @Date: 2019/1/17 20:37
 */
public class TestStaticNestedClass {
    int a = 100;
    String nm = "hello";
    static String val = "val";

    static String h1() {
        System.out.println(StaticInnerClass.name);
        return "h1";
    }

    String h2() {
        System.out.println(StaticInnerClass.m1());
        return "h2";
    }

    void h3() {
        StaticInnerClass innerClass = new StaticInnerClass();
    }


    private static class StaticInnerClass {
        int intValue = 100;
        static String name = "weixiaohuai";

        static String m1() {
            return "m1()";
        }

        public void hello() {
            //1. 不能使用外部类的非静态属性和方法,只能调用静态属性和方法
//            System.out.println(nm);
//            System.out.println(h2());
            System.out.println(val);
            System.out.println(h1());

        }

    }
}
