package com.wsh.jvm.gc01;


/**
 * @Description: 引用计数法
 * @Author: weishihuai
 * @Date: 2019/1/20 09:31
 * <p>
 * 说明：-XX:+PrintGCDetails
 */
public class TestReferenceCounter {

    private Object obj = null;

    public static void main(String[] args) {
        TestReferenceCounter counter1 = new TestReferenceCounter();
        TestReferenceCounter counter2 = new TestReferenceCounter();

        //两个对象相互引用
        counter1.obj = counter2;
        counter2.obj = counter1;

        //将对象置空,并通知垃圾回收器进行回收
        counter1 = null;
        counter2 = null;
        System.gc();
    }

}
