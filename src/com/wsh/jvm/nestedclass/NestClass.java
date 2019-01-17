package com.wsh.jvm.nestedclass;

/**
 * @Description: 匿名内部类
 * @Author: weishihuai
 * @Date: 2019/1/17 21:26
 */
public class NestClass {
    public static void main(String[] args) {
        new Outer02().m1();
    }
}

class Outer02 {

    public void m1() {

        //匿名内部类（方法内部类）
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("run()");
            }
        };

        Test test = new Test() {
            @Override
            public void t() {
                System.out.println("Outer02.t");
            }
        };
        test.t();

    }


}


class Test {
    public void t() {
        System.out.println("Test.t");
    }
}