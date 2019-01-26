package com.wsh.jvm.jvm03;

/**
 * @Description:
 * @author: weishihuai
 * @Date: 2019/1/26 09:48
 */
public class Thread02 implements Runnable {

    private Object object1;
    private Object object2;

    public Thread02(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (object1) {
                System.out.println("Thread02.run");
            }

        }
    }
}
