package com.wsh.jvm.nestedclass;

/**
 * @Description: 内部类
 * @Author: weishihuai
 * @Date: 2019/1/17 20:26
 * <p>
 * 说明:
 * 1. 内部类仍然是一个独立的类，编译之后内部类会被编译成独立的.class文件,前面会加上外部类的类名 + '$'
 * 2. 内部类也可以使用修饰符进行修饰(public / private / default / protected)
 */
public class Demo01 {

    /**
     * 静态内部类
     */
    private static class StaticNestedClass {

    }

    /**
     * 普通内部类(成员内部类)
     */
    private class FidldInnerClass {

    }

    /**
     * 匿名内部类
     */
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    public void test() {
        /**
         * 方法内部类(局部内部类)
         */
        class LocalClass {

        }

        /**
         * 匿名内部类
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }


}
