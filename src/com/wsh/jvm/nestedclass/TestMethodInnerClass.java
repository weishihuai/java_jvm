package com.wsh.jvm.nestedclass;

/**
 * @Description: 方法内部类(局部内部类)
 * @Author: weishihuai
 * @Date: 2019/1/17 21:11
 */
public class TestMethodInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m1();
    }

}

class Outer01 {

    public void m1() {
//        private int v = 20;
        int val = 100;


        //局部内部类不能使用关键字进行修饰
        class MethodInnerClass {

            //在方法内部类里面不能定义静态属性和静态方法
//        static String nm = "aa";

//            static void m2() {
//            }

            void m3() {
                System.out.println(val);
            }

        }

        MethodInnerClass innerClass = new MethodInnerClass();
        innerClass.m3();

    }

    public void m2() {

        //方法内部类只能在定义的方法里面使用，不能在外部使用
//        MethodInnerClass innerClass = new MethodInnerClass();
    }

}


