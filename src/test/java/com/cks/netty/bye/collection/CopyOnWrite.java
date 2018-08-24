package com.cks.netty.bye.collection;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author: cks
 * @Date: Created by 16:21 2018/7/26
 * @Package: com.cks.netty.bye.collection
 * @Description:
 */
public class CopyOnWrite {
    public static void main(String[] args) {
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
//        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        SynchronousQueue queue1 = new SynchronousQueue();
        try {
            queue1.put("123");
            Object a = queue1.take();
            System.out.println(a.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
