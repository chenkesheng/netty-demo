package com.cks.netty.bye.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: cks
 * @Date: Created by 17:43 2018/8/15
 * @Package: com.cks.netty.bye.cglib
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\IdeaProjects\\netty-demo\\target\\test-classes\\com\\cks\\netty\\bye\\cglib");
        CksProxy cksProxy = new CksProxy();
        Cks cks = (Cks) cksProxy.getProxy(Cks.class);
        cks.learnning();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try {
            condition.await();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
