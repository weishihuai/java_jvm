package com.wsh.jvm.nestedclass;

/**
 * @Description: 成员内部类
 * @Author: weishihuai
 * @Date: 2019/1/17 20:49
 */
public class TestFieldInnerClass {

    public static void main(String[] args) {
        //在不相关的类中引用成员内部类,必须要先创建外部类对象，才能创建成员内部类对象
        Outer.FiledInnerClass filedInnerClass = new Outer().new FiledInnerClass();
        filedInnerClass.m1();
    }

}

class Outer {
    private int value = 2;
    public String name = "weixiaohuai";

    public void m2() {
        //在成员内部类所属的外部类中,可以直接创建成员内部类的对象
        FiledInnerClass filedInnerClass = new FiledInnerClass();
    }

    class FiledInnerClass {
        int val = 0;
        //成员内部类不能有静态成员和静态方法
//        static String name = "aaa";

//        static void m3() {
//        }

        //成员内部类允许有常量存在,并且所赋的值必须为常量
        final static int MAX = 10000;

        //因为随机数在编译的时候值不能被确定下来,所以下面的代码会报错
//        final static int value = Math.random();

        void m1() {
            //成员内部类可以直接使用外部类的所有成员(包括private/public/default/protected)
            System.out.println(value);
            System.out.println(name);

            //this表示内部类对象
            //成员内部类对象的存在必须依赖于外部类对象
            System.out.println("内部类对象" + this);
            System.out.println("外部类对象-->" + Outer.this);
        }


    }
}
