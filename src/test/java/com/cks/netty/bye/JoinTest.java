package com.cks.netty.bye;

/**
 * @Author: cks
 * @Date: Created by 14:16 2018/7/25
 * @Package: com.cks.netty.bye
 * @Description:
 */
public class JoinTest {

    public void a(Thread joinThread) {
        System.out.println("a方法执行了.....");
        joinThread.start();
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a方法执行完毕。。。。");
    }

    public void b() {
        System.out.println("加塞线程开始执行....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程执行完毕。。。。");
    }

    public static void main(String[] args) {
        JoinTest joinTest = new JoinTest();

        Thread joinThread = new Thread(new Runnable() {
            @Override
            public void run() {
                joinTest.b();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                joinTest.a(joinThread);
            }
        }).start();
    }
}
