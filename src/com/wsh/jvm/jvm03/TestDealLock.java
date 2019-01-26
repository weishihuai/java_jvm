package com.wsh.jvm.jvm03;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/26 09:51
 */
public class TestDealLock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        new Thread(new Thread01(object1, object2)).start();
        new Thread(new Thread02(object1, object2)).start();
    }
}
