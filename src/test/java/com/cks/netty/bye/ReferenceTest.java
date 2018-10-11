package com.cks.netty.bye;

import com.google.common.base.FinalizablePhantomReference;

/**
 * @Author: cks
 * @Date: Created by 16:03 2018/7/13
 * @Package: com.cks.netty.bye
 * @Description:
 */
public class ReferenceTest {
//    public Object instance = null;
//
//    private static final int _1MB = 1024 * 1024;
//    /**
//     * 这个成员属性的唯一意义就是占点内存，以便在GC日志中看清楚是否被回收过
//     */
//    private byte[] bigSize = new byte[2 * _1MB];
//
//    public static void main(String[] args) {
//
//        ReferenceTest objA = new ReferenceTest();
//        ReferenceTest objB = new ReferenceTest();
//
//        objA.instance = objB;
//        objB.instance = objA;
//
//        /**
//         * 假设在这发生gc，那么objA和objB能否被回收
//         */
//        System.gc();
//    }

    public static ReferenceTest SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes , i am still alive :)");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        ReferenceTest.SAVE_HOOK = this;

    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new ReferenceTest();

        //对象第一次拯救自己
        SAVE_HOOK = null;

        System.gc();

        //因为finalizer优先级低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        SAVE_HOOK = null;

        System.gc();
        //因为finalizer优先级低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
